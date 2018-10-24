
package com.liferay.training.gradebook.web.portlet.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.training.gradebook.service.SubmissionService;
import com.liferay.training.gradebook.web.constants.GradebookPortletKeys;
import com.liferay.training.gradebook.web.constants.MVCCommandNames;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * MVC Action Command for deleting submissions.
 * 
 * @author liferay
 *
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + GradebookPortletKeys.GRADEBOOK,
		"mvc.command.name=" + MVCCommandNames.DELETE_SUBMISSION
	},
	service = MVCActionCommand.class
)
public class DeleteSubmissionMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		// Get submission id for the request.

		long submissionId =
			ParamUtil.getLong(actionRequest, "submissionId");

		if (_log.isDebugEnabled()) {
			_log.debug("Deleting submission " + submissionId);
		}

		try {

			// Call the service to delete the submission.
			
			_submissionService.deleteSubmission(submissionId);
			
			// Set success message.

			SessionMessages.add(actionRequest, "submission-deleted");

			// Hide default success message.
			
			hideDefaultSuccessMessage(actionRequest);

		} catch (PortalException e) {
			
			// Set error messages
			
			SessionErrors.add(actionRequest, "error.submission-service-error");

			_log.error(e);
		}
		
		sendRedirect(actionRequest, actionResponse);
	}

	@Reference
	protected SubmissionService _submissionService;

	private static final Log _log =
		LogFactoryUtil.getLog(DeleteSubmissionMVCActionCommand.class);
}
