
package com.liferay.training.gradebook.web.portlet.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.training.gradebook.model.Assignment;
import com.liferay.training.gradebook.model.Submission;
import com.liferay.training.gradebook.service.AssignmentService;
import com.liferay.training.gradebook.service.SubmissionLocalService;
import com.liferay.training.gradebook.service.permission.AssignmentPermissionChecker;
import com.liferay.training.gradebook.web.constants.GradebookPortletKeys;
import com.liferay.training.gradebook.web.constants.MVCCommandNames;

import java.text.DateFormat;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * MVC Command for showing the submission grading view.
 * 
 * @author liferay
 */
@Component(
	immediate = true, 
	property = {
		"javax.portlet.name=" + GradebookPortletKeys.GRADEBOOK,
		"mvc.command.name=" + MVCCommandNames.GRADE_SUBMISSION
	}, 
	service = MVCRenderCommand.class
)
public class GradeSubmissionMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		ThemeDisplay themeDisplay =
			(ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long submissionId = ParamUtil.getLong(renderRequest, "submissionId", 0);

		try {

			// Call the service to get the submission for grading.
			// Notice that "fetch" returns a null instead of exception,
			// when not found.

			Submission submission =
				_submissionLocalService.fetchSubmission(submissionId);

			long assignmentId;

			if (submission == null) {
				assignmentId = ParamUtil.getLong(renderRequest, "assignmentId");
			}
			else {
				assignmentId = submission.getAssignmentId();
			}

			Assignment assignment =
				_assignmentService.getAssignment(assignmentId);

			DateFormat dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
				"EEEEE, MMMMM dd, yyyy", renderRequest.getLocale());

			renderRequest.setAttribute("assignment", assignment);
			renderRequest.setAttribute("submission", submission);
			renderRequest.setAttribute("submissionClass", Submission.class);
			renderRequest.setAttribute(
				"assignmentPermissionChecker", _assignmentPermissionChecker);

			renderRequest.setAttribute(
				"createDate", dateFormat.format(submission.getCreateDate()));
			renderRequest.setAttribute(
				"student", _userLocalService.getUser(
					submission.getStudentId()).getFullName());

			renderRequest.setAttribute(
				"dueDate", dateFormat.format(assignment.getDueDate()));

			// Set back icon visible.

			PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

			String redirect = renderRequest.getParameter("redirect");

			portletDisplay.setShowBackIcon(true);
			portletDisplay.setURLBack(redirect);

			return "/submission/grade_submission.jsp";
		}
		catch (PortalException e) {
			throw new PortletException(e);
		}
	}

	@Reference
	protected AssignmentPermissionChecker _assignmentPermissionChecker;

	@Reference
	private AssignmentService _assignmentService;

	@Reference
	private SubmissionLocalService _submissionLocalService;

	@Reference
	private UserLocalService _userLocalService;
}
