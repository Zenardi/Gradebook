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

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.spring.extender.service.ServiceReference;
import com.liferay.training.gradebook.model.Assignment;
import com.liferay.training.gradebook.service.base.AssignmentServiceBaseImpl;
import com.liferay.training.gradebook.service.permission.AssignmentPermissionChecker;
import com.liferay.training.gradebook.service.permission.impl.AssignmentPermissionCheckerImpl;

/**
 * The implementation of the assignment remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.training.gradebook.service.AssignmentService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AssignmentServiceBaseImpl
 * @see com.liferay.training.gradebook.service.AssignmentServiceUtil
 */
public class AssignmentServiceImpl extends AssignmentServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.training.gradebook.service.AssignmentServiceUtil} to access the assignment remote service.
	 */
	
	public Assignment addAssignment(long groupId, Map<Locale, String> title, String description, Date dueDate, ServiceContext serviceContext) throws PortalException {

		// Check permissions
		
		_assignmentPermissionChecker.checkTopLevel(
				getPermissionChecker(), serviceContext.getScopeGroupId(),
				AssignmentPermissionCheckerImpl.ADD_ASSIGNMENT);
		
		return assignmentLocalService.addAssignment(groupId, title, description, dueDate, serviceContext);
	}
	
	public Assignment deleteAssignment(long assignmentId) throws PortalException {
		Assignment assignment = assignmentLocalService.getAssignment(assignmentId);
		
		// Check permissions.
		
		_assignmentPermissionChecker.check(
				getPermissionChecker(), assignment.getGroupId(),
				assignment.getAssignmentId(), ActionKeys.DELETE);
		
		return assignmentLocalService.deleteAssignment(assignment);
	}
	
	public Assignment getAssignment(long assignmentId) throws PortalException {	
		Assignment assignment = assignmentLocalService.getAssignment(assignmentId);
		
		// Check permissions.
		
		_assignmentPermissionChecker.check(
			getPermissionChecker(), assignment.getGroupId(),
			assignment.getAssignmentId(), ActionKeys.VIEW);	
	
		return assignment;
	}

	public List<Assignment> getAssignmentsByKeywords(long groupId, String keywords, int start, int end, int status, OrderByComparator<Assignment> orderByComparator) {
		return assignmentLocalService.getAssignmentsByKeywords(groupId, keywords, start, end, status, orderByComparator);
	}
	
	public long getAssignmentsCountByKeywords(long groupId, String keywords, int status) {
		return assignmentLocalService.getAssignmentsCountByKeywords(groupId, keywords, status);
	}
		

	public Assignment updateAssignment(long assignmentId, Map<Locale, String> titleMap, String description, Date dueDate, ServiceContext serviceContext) throws PortalException {

		Assignment assignment = assignmentLocalService.getAssignment(assignmentId);
				
		// Check permissions.
		
		_assignmentPermissionChecker.check(
				getPermissionChecker(), assignment.getGroupId(),
				assignment.getAssignmentId(), ActionKeys.UPDATE);
		
		return assignmentLocalService.updateAssignment(assignmentId, titleMap, description, dueDate, serviceContext);
	}
	
	/**
	 * Service builder classes are not OSGi components but Spring beans and you cannot
	 * use the @Reference annotation. Use @ServiceReference instead.
	 */
	@ServiceReference(type = 
		com.liferay.training.gradebook.service.permission.AssignmentPermissionChecker.class)
	private AssignmentPermissionChecker _assignmentPermissionChecker;
}