
package com.liferay.training.gradebook.web.portlet.action;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.training.gradebook.model.Assignment;
import com.liferay.training.gradebook.model.Submission;
import com.liferay.training.gradebook.service.AssignmentService;
import com.liferay.training.gradebook.service.SubmissionService;
import com.liferay.training.gradebook.service.permission.AssignmentPermissionChecker;
import com.liferay.training.gradebook.web.constants.GradebookPortletKeys;
import com.liferay.training.gradebook.web.constants.MVCCommandNames;
import com.liferay.training.gradebook.web.display.context.SubmissionsManagementToolbarDisplayContext;

import java.text.DateFormat;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * MVC Command for showing the assignment submissions list view.
 * 
 * @author liferay
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + GradebookPortletKeys.GRADEBOOK,
		"mvc.command.name=" + MVCCommandNames.VIEW_SUBMISSIONS
	},
	service = MVCRenderCommand.class
)
public class ViewSubmissionsMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		ThemeDisplay themeDisplay =
			(ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long assignmentId = ParamUtil.getLong(renderRequest, "assignmentId", 0);

		try {

			// Call the service to get the assignment.

			Assignment assignment =
				_assignmentService.getAssignment(assignmentId);

			DateFormat dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
				"EEEEE, MMMMM dd, yyyy", renderRequest.getLocale());

			// Set attributes to the request.

			renderRequest.setAttribute("assignment", assignment);
			renderRequest.setAttribute(
				"assignmentPermissionChecker", _assignmentPermissionChecker);
			renderRequest.setAttribute(
				"dueDate", dateFormat.format(assignment.getDueDate()));
			renderRequest.setAttribute(
				"createDate", dateFormat.format(assignment.getCreateDate()));

			// Add other related attributes.

			addSubmissionListAttributes(
				renderRequest, renderResponse, assignmentId);

			// Set back icon visible.

			PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

			String redirect = renderRequest.getParameter("redirect");

			portletDisplay.setShowBackIcon(true);
			portletDisplay.setURLBack(redirect);

			return "/submission/view_submissions.jsp";

		}
		catch (PortalException e) {
			throw new PortletException(e);
		}
	}

	/**
	 * Adds submission list related attributes to the request.
	 * 
	 * @param renderRequest
	 * @throws PortalException
	 */
	private void addSubmissionListAttributes(
		RenderRequest renderRequest, RenderResponse renderResponse,
		long assignmentId) throws PortalException {

		ThemeDisplay themeDisplay =
			(ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		// Resolve start and end for the search.

		int currentPage = ParamUtil.getInteger(
			renderRequest, SearchContainer.DEFAULT_CUR_PARAM,
			SearchContainer.DEFAULT_CUR);

		int delta = ParamUtil.getInteger(
			renderRequest, SearchContainer.DEFAULT_DELTA_PARAM,
			SearchContainer.DEFAULT_DELTA);

		int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;
		int end = start + delta;

		// Get sorting options.

		String orderByCol =
			ParamUtil.getString(renderRequest, "orderByCol", "createDate");
		String orderByType =
			ParamUtil.getString(renderRequest, "orderByType", "asc");

		// Create comparator.

		OrderByComparator<Submission> comp =
			OrderByComparatorFactoryUtil.create(
				"Submission", orderByCol, !("asc").equals(orderByType));

		// Get keywords.

		String keywords = ParamUtil.getString(renderRequest, "keywords");
		
		// Call the service to get the list of submissions.
		// Notice that the search only targets to submissionText field.

		List<Submission> submissions =
			_submissionService.getSubmissionsByKeywords(
				themeDisplay.getScopeGroupId(), assignmentId, keywords, start,
				end, comp);

		long submissionsCount =
			_submissionService.getSubmissionsCountByKeywords(
				themeDisplay.getScopeGroupId(), assignmentId, keywords);

		// Set request attributes.

		renderRequest.setAttribute("submissions", submissions);
		renderRequest.setAttribute("submissionsCount", submissionsCount);

		// Add Clay management toolbar related attributes

		addManagementToolbarAttributes(
			renderRequest, renderResponse, submissions, assignmentId);
	}

	/**
	 * Adds Clay management toolbar context object to the request.
	 * 
	 * @param renderRequest
	 * @param renderResponse
	 * @throws PortalException
	 */
	private void addManagementToolbarAttributes(
		RenderRequest renderRequest, RenderResponse renderResponse,
		List<Submission> submissions, long assignmentId)
		throws PortalException {

		LiferayPortletRequest liferayPortletRequest =
			_portal.getLiferayPortletRequest(renderRequest);

		LiferayPortletResponse liferayPortletResponse =
			_portal.getLiferayPortletResponse(renderResponse);

		// Check whether we should allow adding new assignments.
		// We don't if user has already submitted and the configuration
		// does allow only one submissions per user.

		boolean canAddSubmission = canAddSubmission(submissions, renderRequest);

		SubmissionsManagementToolbarDisplayContext submissionsManagementToolbarDisplayContext =
			new SubmissionsManagementToolbarDisplayContext(
				liferayPortletRequest, liferayPortletResponse,
				_portal.getHttpServletRequest(renderRequest),
				_assignmentPermissionChecker, assignmentId, canAddSubmission);

		renderRequest.setAttribute(
			"submissionsManagementToolbarDisplayContext",
			submissionsManagementToolbarDisplayContext);
	}

	/**
	 * Returns <code>true</code> if user is allowed to do submit.
	 * 
	 * @param submissions
	 *            list of submissions
	 * @param renderRequest
	 * @return
	 * @throws PortalException
	 */
	private boolean canAddSubmission(
		List<Submission> submissions, RenderRequest renderRequest)
		throws PortalException {

		ThemeDisplay themeDisplay =
			(ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long userId = themeDisplay.getUserId();

		// Get the configuration value.

		boolean isAllowMultipleSubmissions = false; 

		/***** [PLACEHOLDER FOR READING THE CONFIGURATION] *****/

		boolean hasAlreadySubmitted = false;

		if (submissions != null) {
			for (Submission submission : submissions) {
				if (submission.getStudentId() == userId) {
					hasAlreadySubmitted = true;
					break;
				}
			}
		}

		if (!hasAlreadySubmitted ||
			(hasAlreadySubmitted && isAllowMultipleSubmissions)) {
			return true;
		}

		return false;
	}

	@Reference
	protected AssignmentPermissionChecker _assignmentPermissionChecker;

	@Reference
	private AssignmentService _assignmentService;

	@Reference
	private Portal _portal;

	@Reference
	private SubmissionService _submissionService;

	@Reference
	private UserLocalService _userLocalService;

}
