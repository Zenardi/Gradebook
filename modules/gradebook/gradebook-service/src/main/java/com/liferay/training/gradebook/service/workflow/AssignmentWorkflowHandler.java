
package com.liferay.training.gradebook.service.workflow;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.permission.ResourceActions;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandler;
import com.liferay.training.gradebook.model.Assignment;
import com.liferay.training.gradebook.service.AssignmentLocalService;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * Assignments workflow handler.
 * 
 * @author liferay
 */
@Component(
	immediate = true, 
	service = WorkflowHandler.class
)
public class AssignmentWorkflowHandler extends BaseWorkflowHandler<Assignment> {

	@Override
	public String getClassName() {

		return Assignment.class.getName();
	}

	@Override
	public String getType(Locale locale) {

		return _resourceActions.getModelResource(locale, getClassName());
	}

	@Override
	public Assignment updateStatus(
		int status, Map<String, Serializable> workflowContext)
		throws PortalException {

		long userId = GetterUtil.getLong(
			(String) workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));

		long resourcePrimKey = GetterUtil.getLong(
			(String) workflowContext.get(
				WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));

		if (_log.isDebugEnabled()) {
			_log.debug(
				"Updating workflow status for assignment " + resourcePrimKey);
		}

		ServiceContext serviceContext =
			(ServiceContext) workflowContext.get("serviceContext");

		return _assigmentLocalService.updateStatus(
			userId, resourcePrimKey, status, serviceContext);
	}

	@Reference
	private AssignmentLocalService _assigmentLocalService;

	@Reference
	private ResourceActions _resourceActions;

	private Log _log = LogFactoryUtil.getLog(AssignmentWorkflowHandler.class);

}
