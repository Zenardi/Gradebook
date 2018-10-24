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

package com.liferay.training.gradebook.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AssignmentLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AssignmentLocalService
 * @generated
 */
@ProviderType
public class AssignmentLocalServiceWrapper implements AssignmentLocalService,
	ServiceWrapper<AssignmentLocalService> {
	public AssignmentLocalServiceWrapper(
		AssignmentLocalService assignmentLocalService) {
		_assignmentLocalService = assignmentLocalService;
	}

	/**
	* Adds the assignment to the database. Also notifies the appropriate model listeners.
	*
	* @param assignment the assignment
	* @return the assignment that was added
	*/
	@Override
	public com.liferay.training.gradebook.model.Assignment addAssignment(
		com.liferay.training.gradebook.model.Assignment assignment) {
		return _assignmentLocalService.addAssignment(assignment);
	}

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
	@Override
	public com.liferay.training.gradebook.model.Assignment addAssignment(
		long groupId,
		java.util.Map<java.util.Locale, java.lang.String> titleMap,
		java.lang.String description, java.util.Date dueDate,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _assignmentLocalService.addAssignment(groupId, titleMap,
			description, dueDate, serviceContext);
	}

	/**
	* Creates a new assignment with the primary key. Does not add the assignment to the database.
	*
	* @param assignmentId the primary key for the new assignment
	* @return the new assignment
	*/
	@Override
	public com.liferay.training.gradebook.model.Assignment createAssignment(
		long assignmentId) {
		return _assignmentLocalService.createAssignment(assignmentId);
	}

	/**
	* Deletes the assignment from the database. Also notifies the appropriate model listeners.
	*
	* @param assignment the assignment
	* @return the assignment that was removed
	* @throws PortalException
	*/
	@Override
	public com.liferay.training.gradebook.model.Assignment deleteAssignment(
		com.liferay.training.gradebook.model.Assignment assignment)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _assignmentLocalService.deleteAssignment(assignment);
	}

	/**
	* Deletes the assignment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param assignmentId the primary key of the assignment
	* @return the assignment that was removed
	* @throws PortalException if a assignment with the primary key could not be found
	*/
	@Override
	public com.liferay.training.gradebook.model.Assignment deleteAssignment(
		long assignmentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _assignmentLocalService.deleteAssignment(assignmentId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _assignmentLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _assignmentLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _assignmentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.gradebook.model.impl.AssignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _assignmentLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.gradebook.model.impl.AssignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _assignmentLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _assignmentLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _assignmentLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.training.gradebook.model.Assignment fetchAssignment(
		long assignmentId) {
		return _assignmentLocalService.fetchAssignment(assignmentId);
	}

	/**
	* Returns the assignment matching the UUID and group.
	*
	* @param uuid the assignment's UUID
	* @param groupId the primary key of the group
	* @return the matching assignment, or <code>null</code> if a matching assignment could not be found
	*/
	@Override
	public com.liferay.training.gradebook.model.Assignment fetchAssignmentByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return _assignmentLocalService.fetchAssignmentByUuidAndGroupId(uuid,
			groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _assignmentLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the assignment with the primary key.
	*
	* @param assignmentId the primary key of the assignment
	* @return the assignment
	* @throws PortalException if a assignment with the primary key could not be found
	*/
	@Override
	public com.liferay.training.gradebook.model.Assignment getAssignment(
		long assignmentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _assignmentLocalService.getAssignment(assignmentId);
	}

	/**
	* Returns the assignment matching the UUID and group.
	*
	* @param uuid the assignment's UUID
	* @param groupId the primary key of the group
	* @return the matching assignment
	* @throws PortalException if a matching assignment could not be found
	*/
	@Override
	public com.liferay.training.gradebook.model.Assignment getAssignmentByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _assignmentLocalService.getAssignmentByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns a range of all the assignments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.gradebook.model.impl.AssignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of assignments
	* @param end the upper bound of the range of assignments (not inclusive)
	* @return the range of assignments
	*/
	@Override
	public java.util.List<com.liferay.training.gradebook.model.Assignment> getAssignments(
		int start, int end) {
		return _assignmentLocalService.getAssignments(start, end);
	}

	@Override
	public java.util.List<com.liferay.training.gradebook.model.Assignment> getAssignmentsByGroupId(
		long groupId) {
		return _assignmentLocalService.getAssignmentsByGroupId(groupId);
	}

	@Override
	public java.util.List<com.liferay.training.gradebook.model.Assignment> getAssignmentsByGroupId(
		long groupId, int start, int end) {
		return _assignmentLocalService.getAssignmentsByGroupId(groupId, start,
			end);
	}

	@Override
	public java.util.List<com.liferay.training.gradebook.model.Assignment> getAssignmentsByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.training.gradebook.model.Assignment> orderByComparator) {
		return _assignmentLocalService.getAssignmentsByGroupId(groupId, start,
			end, orderByComparator);
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
	@Override
	public java.util.List<com.liferay.training.gradebook.model.Assignment> getAssignmentsByKeywords(
		long groupId, java.lang.String keywords, int start, int end,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.training.gradebook.model.Assignment> orderByComparator) {
		return _assignmentLocalService.getAssignmentsByKeywords(groupId,
			keywords, start, end, status, orderByComparator);
	}

	@Override
	public java.util.List<com.liferay.training.gradebook.model.Assignment> getAssignmentsByStatus(
		int status) {
		return _assignmentLocalService.getAssignmentsByStatus(status);
	}

	/**
	* Returns all the assignments matching the UUID and company.
	*
	* @param uuid the UUID of the assignments
	* @param companyId the primary key of the company
	* @return the matching assignments, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.liferay.training.gradebook.model.Assignment> getAssignmentsByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _assignmentLocalService.getAssignmentsByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns a range of assignments matching the UUID and company.
	*
	* @param uuid the UUID of the assignments
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of assignments
	* @param end the upper bound of the range of assignments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching assignments, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.liferay.training.gradebook.model.Assignment> getAssignmentsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.training.gradebook.model.Assignment> orderByComparator) {
		return _assignmentLocalService.getAssignmentsByUuidAndCompanyId(uuid,
			companyId, start, end, orderByComparator);
	}

	/**
	* Returns the number of assignments.
	*
	* @return the number of assignments
	*/
	@Override
	public int getAssignmentsCount() {
		return _assignmentLocalService.getAssignmentsCount();
	}

	@Override
	public int getAssignmentsCountByGroupId(long groupId) {
		return _assignmentLocalService.getAssignmentsCountByGroupId(groupId);
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
	@Override
	public long getAssignmentsCountByKeywords(long groupId,
		java.lang.String keywords, int status) {
		return _assignmentLocalService.getAssignmentsCountByKeywords(groupId,
			keywords, status);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _assignmentLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _assignmentLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _assignmentLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _assignmentLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the assignment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param assignment the assignment
	* @return the assignment that was updated
	*/
	@Override
	public com.liferay.training.gradebook.model.Assignment updateAssignment(
		com.liferay.training.gradebook.model.Assignment assignment) {
		return _assignmentLocalService.updateAssignment(assignment);
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
	@Override
	public com.liferay.training.gradebook.model.Assignment updateAssignment(
		long assignmentId,
		java.util.Map<java.util.Locale, java.lang.String> titleMap,
		java.lang.String description, java.util.Date dueDate,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _assignmentLocalService.updateAssignment(assignmentId, titleMap,
			description, dueDate, serviceContext);
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
	@Override
	public com.liferay.training.gradebook.model.Assignment updateStatus(
		long userId, long assignmentId, int status,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _assignmentLocalService.updateStatus(userId, assignmentId,
			status, serviceContext);
	}

	@Override
	public AssignmentLocalService getWrappedService() {
		return _assignmentLocalService;
	}

	@Override
	public void setWrappedService(AssignmentLocalService assignmentLocalService) {
		_assignmentLocalService = assignmentLocalService;
	}

	private AssignmentLocalService _assignmentLocalService;
}