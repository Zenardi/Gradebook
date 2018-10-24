
package com.liferay.training.gradebook.web.portlet.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.training.gradebook.exception.SubmissionValidationException;
import com.liferay.training.gradebook.model.Submission;
import com.liferay.training.gradebook.service.SubmissionService;
import com.liferay.training.gradebook.web.constants.GradebookPortletKeys;
import com.liferay.training.gradebook.web.constants.MVCCommandNames;

/**
 * MVC Command for adding and editing submissions.
 * 
 * @author liferay
 *
 */
@Component(
	immediate = true, 
	property = {
		"javax.portlet.name=" + GradebookPortletKeys.GRADEBOOK,
		"mvc.command.name=" + MVCCommandNames.ADD_SUBMISSION,
		"mvc.command.name=" + MVCCommandNames.EDIT_SUBMISSION
	}, 
	service = MVCActionCommand.class
)
public class EditSubmissionMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay =
			(ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		try {

			// Create service context.

			ServiceContext serviceContext = ServiceContextFactory.getInstance(
				Submission.class.getName(), actionRequest);

			String submissionText =
				ParamUtil.getString(actionRequest, "submissionText");

			// Do edit or add action.

			if (isEditAction(actionRequest)) {

				long submissionId =
					ParamUtil.getLong(actionRequest, "submissionId");

				// Call the service to update the submission.

				_submissionService.updateSubmission(
					submissionId, submissionText, serviceContext);

				// Set the success message

				SessionMessages.add(actionRequest, "submission-updated");

			}
			else {
				long assignmentId =
					ParamUtil.getLong(actionRequest, "assignmentId");

				long studentUserId = themeDisplay.getUserId();

				_submissionService.addSubmission(
					assignmentId, studentUserId, submissionText,
					serviceContext);
				SessionMessages.add(actionRequest, "submission-added");
			}

			// Hide default success message.

			hideDefaultSuccessMessage(actionRequest);

			sendRedirect(actionRequest, actionResponse);
		}
		catch (SubmissionValidationException e) {

			e.getErrors().forEach(key -> SessionErrors.add(actionRequest, key));

			// Hide default error message

			hideDefaultErrorMessage(actionRequest);
			
			actionResponse.setRenderParameter(
				"mvcRenderCommandName", MVCCommandNames.EDIT_SUBMISSION);			
		}
		catch (PortalException e) {

			_log.error(e);
			
			// Set error message.

			SessionErrors.add(actionRequest, "error.assignment-service-error");

			actionResponse.setRenderParameter(
				"mvcRenderCommandName", MVCCommandNames.EDIT_SUBMISSION);			
		}
	}

	/**
	 * Returns <code>true</code> if we are editing.
	 * 
	 * @param actionRequest
	 * @return <code>true</code> if we are editing; <code>false</code> otherwise
	 */
	private boolean isEditAction(ActionRequest actionRequest) {

		return ParamUtil.getString(
			actionRequest, ActionRequest.ACTION_NAME,
			MVCCommandNames.ADD_SUBMISSION).indexOf(
				MVCCommandNames.EDIT_SUBMISSION) >= 0;
	}

	@Reference
	protected SubmissionService _submissionService;

	@Reference
	protected Portal _portal;

	private static final Log _log =
		LogFactoryUtil.getLog(EditSubmissionMVCActionCommand.class);
}
