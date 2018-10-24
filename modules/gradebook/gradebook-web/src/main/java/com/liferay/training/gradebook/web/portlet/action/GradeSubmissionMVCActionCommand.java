
package com.liferay.training.gradebook.web.portlet.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.training.gradebook.exception.SubmissionValidationException;
import com.liferay.training.gradebook.service.SubmissionService;
import com.liferay.training.gradebook.web.constants.GradebookPortletKeys;
import com.liferay.training.gradebook.web.constants.MVCCommandNames;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * MVC Command for grading submissions.
 * 
 * @author liferay
 *
 */
@Component(
	immediate = true, 
	property = {
		"javax.portlet.name=" + GradebookPortletKeys.GRADEBOOK,
		"mvc.command.name=" + MVCCommandNames.GRADE_SUBMISSION
	}, 
	service = MVCActionCommand.class
)
public class GradeSubmissionMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		// Get parameters from request.
		
		long submissionId = ParamUtil.getLong(actionRequest, "submissionId");
		int grade = ParamUtil.getInteger(actionRequest, "grade");
		String comment = ParamUtil.getString(actionRequest, "comment");
		
		if (_log.isDebugEnabled()) {
			_log.debug("Grading submission " + submissionId);
		}
		
		try {
			
			// Call the service to grade and comment.
			
			_submissionService.gradeAndCommentSubmission(
				submissionId, grade, comment);

			// Set success message.

			SessionMessages.add(actionRequest, "submission-graded");

			// Hide default success message.

			hideDefaultSuccessMessage(actionRequest);
			
			sendRedirect(actionRequest, actionResponse);
		}
		catch (SubmissionValidationException e) {

			// Set errors.
			
			e.getErrors().forEach(key -> SessionErrors.add(actionRequest, key));

			actionResponse.setRenderParameter(
				"mvcRenderCommandName", MVCCommandNames.GRADE_SUBMISSION);			
		}
	}

	@Reference
	protected SubmissionService _submissionService;

	private static final Log _log =
		LogFactoryUtil.getLog(GradeSubmissionMVCActionCommand.class);
}
