/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.training.gradebook.service.impl;

import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.training.gradebook.model.Assignment;
import com.liferay.training.gradebook.service.base.AssignmentLocalServiceBaseImpl;
import com.liferay.training.gradebook.service.validation.AssignmentValidator;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * The implementation of the assignment local service. <p> All custom service
 * methods should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the
 * {@link com.liferay.training.gradebook.service.AssignmentLocalService}
 * interface. <p> This is a local service. Methods of this service will not have
 * security checks based on the propagated JAAS credentials because this service
 * can only be accessed from within the same VM. </p>
 *
 * @author Brian Wing Shun Chan
 * @see AssignmentLocalServiceBaseImpl
 * @see com.liferay.training.gradebook.service.AssignmentLocalServiceUtil
 */
public class AssignmentLocalServiceImpl extends AssignmentLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS: Never reference this class directly. Always use
	 * {@link com.liferay.training.gradebook.service.AssignmentLocalServiceUtil}
	 * to access the assignment local service.
	 */

	/**
	 * Adds an assignment.
	 * 
	 * @param groupId
	 * @param titleMap
	 * @param description
	 * @param dueDate
	 * @param serviceContext
	 * @return
	 * @throws PortalException
	 */
	@Indexable(
		type = IndexableType.REINDEX
	)
	public Assignment addAssignment(
		long groupId, Map<Locale, String> titleMap, String description,
		Date dueDate, ServiceContext serviceContext)
		throws PortalException {

		// Validate assignment parameters.

		AssignmentValidator.validate(titleMap, description, dueDate);

		// Get group and same time validate that it exists.

		Group group = groupPersistence.findByPrimaryKey(groupId);

		long userId = serviceContext.getUserId();

		User user = userLocalService.getUser(userId);

		// Generate primary key for the assignment.

		long assignmentId =
			counterLocalService.increment(Assignment.class.getName());

		// Create assigment.

		Assignment assignment = createAssignment(assignmentId);

		// Fill the assignment

		assignment.setCompanyId(group.getCompanyId());
		assignment.setGroupId(groupId);
		assignment.setUserId(userId);
		assignment.setTitleMap(titleMap);
		assignment.setDueDate(dueDate);
		assignment.setDescription(description);
		assignment.setStatus(WorkflowConstants.STATUS_DRAFT);
		assignment.setStatusByUserId(userId);
		assignment.setStatusByUserName(user.getFullName());
		assignment.setStatusDate(serviceContext.getModifiedDate(null));
		assignment.setUserName(user.getScreenName());

		assignment.setCreateDate(serviceContext.getCreateDate(new Date()));
		assignment.setModifiedDate(serviceContext.getModifiedDate(new Date()));

		// Persist assignment.

		assignment = super.addAssignment(assignment);

		// Add permission resources.
		
		boolean portletActions = false;
		boolean addGroupPermissions = true;
		boolean addGuestPermissions = true;

		resourceLocalService.addResources(
			group.getCompanyId(), groupId, userId, Assignment.class.getName(),
			assignment.getAssignmentId(), portletActions, addGroupPermissions,
			addGuestPermissions);

		// Update asset.

		updateAsset(assignment, serviceContext);

		// Start workflow instance and return the assignment.

		return startWorkflowInstance(userId, assignment, serviceContext);
	}

	/**
	 * Adds an assigment (silenced)
	 * 
	 * This is an example how to "silence" generated method.
	 * 
	 * @param assignment
	 * @return
	 */
	@Override
	public Assignment addAssignment(Assignment assignment) {

		throw new UnsupportedOperationException(
			"please use instead addAssignment(Assignment, ServiceContext)");
	}

	@Indexable(
		type = IndexableType.DELETE
	)
	public Assignment deleteAssignment(long assignmentId)
		throws PortalException {

		Assignment assignment = getAssignment(assignmentId);

		return deleteAssignment(assignment);
	}

	/**
	 * Deletes assignment.
	 * 
	 * @param assignment
	 * @return
	 * @throws PortalException
	 */
	@Indexable(
		type = IndexableType.DELETE
	)
	public Assignment deleteAssignment(Assignment assignment)
		throws PortalException {

		// Delete permission resources.

		resourceLocalService.deleteResource(
			assignment, ResourceConstants.SCOPE_INDIVIDUAL);

		// Delete asset data.

		assetEntryLocalService.deleteEntry(
			Assignment.class.getName(), assignment.getAssignmentId());

		// Delete workflow instance.

		workflowInstanceLinkLocalService.deleteWorkflowInstanceLinks(
			assignment.getCompanyId(), assignment.getGroupId(),
			Assignment.class.getName(), assignment.getAssignmentId());

		// Delete the Assignment

		return super.deleteAssignment(assignment);
	}

	public List<Assignment> getAssignmentsByGroupId(long groupId) {

		return assignmentPersistence.findByGroupId(groupId);
	}

	public List<Assignment> getAssignmentsByGroupId(
		long groupId, int start, int end) {

		return assignmentPersistence.findByGroupId(groupId, start, end);
	}

	public List<Assignment> getAssignmentsByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Assignment> orderByComparator) {

		return assignmentPersistence.findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Gets assignments by keywords and status.
	 * 
	 * This example uses dynamic queries.
	 * 
	 * @param groupId
	 * @param keywords
	 * @param start
	 * @param end
	 * @param status
	 * @param orderByComparator
	 * @return
	 */
	public List<Assignment> getAssignmentsByKeywords(
		long groupId, String keywords, int start, int end, int status,
		OrderByComparator<Assignment> orderByComparator) {

		DynamicQuery assignmentQuery =
			dynamicQuery().add(RestrictionsFactoryUtil.eq("groupId", groupId));

		if (status != WorkflowConstants.STATUS_ANY) {
			assignmentQuery.add(RestrictionsFactoryUtil.eq("status", status));
		}

		if (Validator.isNotNull(keywords)) {
			Disjunction disjunctionQuery =
				RestrictionsFactoryUtil.disjunction();
			disjunctionQuery.add(
				RestrictionsFactoryUtil.like("title", "%" + keywords + "%"));
			disjunctionQuery.add(
				RestrictionsFactoryUtil.like(
					"description", "%" + keywords + "%"));
			assignmentQuery.add(disjunctionQuery);
		}

		return assignmentLocalService.dynamicQuery(
			assignmentQuery, start, end, orderByComparator);
	}

	public List<Assignment> getAssignmentsByStatus(int status) {

		return assignmentPersistence.findByStatus(status);
	}

	
	public int getAssignmentsCountByGroupId(long groupId) {

		return assignmentPersistence.countByGroupId(groupId);
	}

	/**
	 * Get assignment count by keywords and status.
	 * 
	 * This example uses dynamic queries.
	 * 
	 * @param groupId
	 * @param keywords
	 * @param status
	 * @return
	 */
	public long getAssignmentsCountByKeywords(
		long groupId, String keywords, int status) {

		DynamicQuery assignmentQuery =
			dynamicQuery().add(RestrictionsFactoryUtil.eq("groupId", groupId));

		if (status != WorkflowConstants.STATUS_ANY) {
			assignmentQuery.add(RestrictionsFactoryUtil.eq("status", status));
		}

		if (Validator.isNotNull(keywords)) {
			Disjunction disjunctionQuery =
				RestrictionsFactoryUtil.disjunction();
			disjunctionQuery.add(
				RestrictionsFactoryUtil.like("title", "%" + keywords + "%"));
			disjunctionQuery.add(
				RestrictionsFactoryUtil.like(
					"description", "%" + keywords + "%"));
			assignmentQuery.add(disjunctionQuery);
		}

		return assignmentLocalService.dynamicQueryCount(assignmentQuery);
	}


	/**
	 * Updates assignment.
	 * 
	 * @param assignmentId
	 * @param titleMap
	 * @param description
	 * @param dueDate
	 * @param serviceContext
	 * @return
	 * @throws PortalException
	 */
	@Indexable(
		type = IndexableType.REINDEX
	)
	public Assignment updateAssignment(
		long assignmentId, Map<Locale, String> titleMap, String description,
		Date dueDate, ServiceContext serviceContext)
		throws PortalException {

		// Validate assignment values

		AssignmentValidator.validate(titleMap, description, dueDate);

		// Get Assignment

		Assignment assignment = getAssignment(assignmentId);

		// Update the changes to assignment

		assignment.setModifiedDate(new Date());
		assignment.setTitleMap(titleMap);
		assignment.setDueDate(dueDate);
		assignment.setDescription(description);

		assignment = super.updateAssignment(assignment);

		updateAsset(assignment, serviceContext);

		return assignment;
	}

	/**
	 * Updates assigment (silenced)
	 * 
	 * This is an example how to "silence" generated method.
	 * 
	 * @param assignment
	 * @return
	 */
	@Override
	public Assignment updateAssignment(Assignment assignment) {

		throw new UnsupportedOperationException(
			"please use instead updateAssignment(assignmentId, titleMap, description, dueDate, serviceContext)");
	}

	/**
	 * Updates model's workflow status.
	 * 
	 * @param userId
	 * @param assignmentId
	 * @param status
	 * @param serviceContext
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public Assignment updateStatus(
		long userId, long assignmentId, int status,
		ServiceContext serviceContext)
		throws PortalException, SystemException {

		User user = userLocalService.getUser(userId);
		Assignment assignment = getAssignment(assignmentId);

		assignment.setStatus(status);
		assignment.setStatusByUserId(userId);
		assignment.setStatusByUserName(user.getFullName());
		assignment.setStatusDate(new Date());

		assignmentPersistence.update(assignment);

		if (status == WorkflowConstants.STATUS_APPROVED) {

			assetEntryLocalService.updateVisible(
				Assignment.class.getName(), assignmentId, true);

		}
		else {

			assetEntryLocalService.updateVisible(
				Assignment.class.getName(), assignmentId, false);
		}

		return assignment;
	}
	
	/**
	 * Starts model workflow instance.
	 * 
	 * @param userId
	 * @param assignment
	 * @param serviceContext
	 * @return
	 * @throws PortalException
	 */
	protected Assignment startWorkflowInstance(
		long userId, Assignment assignment, ServiceContext serviceContext)
		throws PortalException {

		Map<String, Serializable> workflowContext = new HashMap();

		String userPortraitURL = StringPool.BLANK;
		String userURL = StringPool.BLANK;

		if (serviceContext.getThemeDisplay() != null) {
			User user = userLocalService.getUser(userId);

			userPortraitURL =
				user.getPortraitURL(serviceContext.getThemeDisplay());
			userURL = user.getDisplayURL(serviceContext.getThemeDisplay());
		}

		workflowContext.put(
			WorkflowConstants.CONTEXT_USER_PORTRAIT_URL, userPortraitURL);
		workflowContext.put(WorkflowConstants.CONTEXT_USER_URL, userURL);

		return WorkflowHandlerRegistryUtil.startWorkflowInstance(
			assignment.getCompanyId(), assignment.getGroupId(), userId,
			Assignment.class.getName(), assignment.getAssignmentId(),
			assignment, serviceContext, workflowContext);
	}
	
	/**
	 * Updates asset model related asset.
	 * 
	 * @param assignment
	 * @param serviceContext
	 * @throws PortalException
	 */
	private void updateAsset(
		Assignment assignment, ServiceContext serviceContext)
		throws PortalException {

		assetEntryLocalService.updateEntry(
			serviceContext.getUserId(), serviceContext.getScopeGroupId(),
			assignment.getCreateDate(), assignment.getModifiedDate(),
			Assignment.class.getName(), assignment.getAssignmentId(),
			assignment.getUuid(), 0, serviceContext.getAssetCategoryIds(),
			serviceContext.getAssetTagNames(), true, true,
			assignment.getCreateDate(), null, null, null,
			ContentTypes.TEXT_HTML,
			assignment.getTitle(serviceContext.getLocale()),
			assignment.getDescription(), null, null, null, 0, 0,
			serviceContext.getAssetPriority());
	}	
}
