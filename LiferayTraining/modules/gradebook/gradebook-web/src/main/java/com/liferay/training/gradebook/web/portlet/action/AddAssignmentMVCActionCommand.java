
package com.liferay.training.gradebook.web.portlet.action;

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
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.training.gradebook.exception.AssignmentValidationException;
import com.liferay.training.gradebook.model.Assignment;
import com.liferay.training.gradebook.service.AssignmentService;
import com.liferay.training.gradebook.web.constants.GradebookPortletKeys;
import com.liferay.training.gradebook.web.constants.MVCCommandNames;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * MVC Action Command for adding assignments.
 * 
 * @author liferay
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + GradebookPortletKeys.GRADEBOOK,
		"mvc.command.name=" + MVCCommandNames.ADD_ASSIGNMENT
	},
	service = MVCActionCommand.class
)
public class AddAssignmentMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay =
			(ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			Assignment.class.getName(), actionRequest);

		// Get parameters from the request.

		// Use LocalizationUtil to get a localized parameter.

		Map<Locale, String> title =
			LocalizationUtil.getLocalizationMap(actionRequest, "title");

		String description = ParamUtil.getString(actionRequest, "description");

		Date dueDate = ParamUtil.getDate(
			actionRequest, "dueDate",
			DateFormatFactoryUtil.getDate(actionRequest.getLocale()));

		try {

			// Call the service to add a a new assignment.
			
			_assignmentService.addAssignment(
				themeDisplay.getScopeGroupId(), title, description, dueDate,
				serviceContext);

			// Set success message.

			SessionMessages.add(actionRequest, "assignment-added");

			// Hide default success message.

			hideDefaultSuccessMessage(actionRequest);
			
			sendRedirect(actionRequest, actionResponse);
		}
		catch (AssignmentValidationException e) {

			// Set error messages from the service layer.

			e.getErrors().forEach(key -> SessionErrors.add(actionRequest, key));
			
			actionResponse.setRenderParameter(
				"mvcRenderCommandName", MVCCommandNames.EDIT_ASSIGNMENT);			

		}
		catch (PortalException e) {

			_log.error(e);

			// Set error message.

			SessionErrors.add(actionRequest, "error.assignment-service-error");
			
			actionResponse.setRenderParameter(
				"mvcRenderCommandName", MVCCommandNames.EDIT_ASSIGNMENT);			
		}
	}

	@Reference
	protected AssignmentService _assignmentService;

	private static final Log _log =
		LogFactoryUtil.getLog(AddAssignmentMVCActionCommand.class);
}
