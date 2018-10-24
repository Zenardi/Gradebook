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

package com.liferay.training.gradebook.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.liferay.training.gradebook.model.Assignment;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the assignment service. This utility wraps {@link com.liferay.training.gradebook.service.persistence.impl.AssignmentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AssignmentPersistence
 * @see com.liferay.training.gradebook.service.persistence.impl.AssignmentPersistenceImpl
 * @generated
 */
@ProviderType
public class AssignmentUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Assignment assignment) {
		getPersistence().clearCache(assignment);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Assignment> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Assignment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Assignment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Assignment> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Assignment update(Assignment assignment) {
		return getPersistence().update(assignment);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Assignment update(Assignment assignment,
		ServiceContext serviceContext) {
		return getPersistence().update(assignment, serviceContext);
	}

	/**
	* Returns all the assignments where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching assignments
	*/
	public static List<Assignment> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the assignments where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AssignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of assignments
	* @param end the upper bound of the range of assignments (not inclusive)
	* @return the range of matching assignments
	*/
	public static List<Assignment> findByUuid(java.lang.String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the assignments where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AssignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of assignments
	* @param end the upper bound of the range of assignments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching assignments
	*/
	public static List<Assignment> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Assignment> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the assignments where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AssignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of assignments
	* @param end the upper bound of the range of assignments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching assignments
	*/
	public static List<Assignment> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Assignment> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first assignment in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching assignment
	* @throws NoSuchAssignmentException if a matching assignment could not be found
	*/
	public static Assignment findByUuid_First(java.lang.String uuid,
		OrderByComparator<Assignment> orderByComparator)
		throws com.liferay.training.gradebook.exception.NoSuchAssignmentException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first assignment in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching assignment, or <code>null</code> if a matching assignment could not be found
	*/
	public static Assignment fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<Assignment> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last assignment in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching assignment
	* @throws NoSuchAssignmentException if a matching assignment could not be found
	*/
	public static Assignment findByUuid_Last(java.lang.String uuid,
		OrderByComparator<Assignment> orderByComparator)
		throws com.liferay.training.gradebook.exception.NoSuchAssignmentException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last assignment in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching assignment, or <code>null</code> if a matching assignment could not be found
	*/
	public static Assignment fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<Assignment> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the assignments before and after the current assignment in the ordered set where uuid = &#63;.
	*
	* @param assignmentId the primary key of the current assignment
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next assignment
	* @throws NoSuchAssignmentException if a assignment with the primary key could not be found
	*/
	public static Assignment[] findByUuid_PrevAndNext(long assignmentId,
		java.lang.String uuid, OrderByComparator<Assignment> orderByComparator)
		throws com.liferay.training.gradebook.exception.NoSuchAssignmentException {
		return getPersistence()
				   .findByUuid_PrevAndNext(assignmentId, uuid, orderByComparator);
	}

	/**
	* Removes all the assignments where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of assignments where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching assignments
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the assignment where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchAssignmentException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching assignment
	* @throws NoSuchAssignmentException if a matching assignment could not be found
	*/
	public static Assignment findByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.training.gradebook.exception.NoSuchAssignmentException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the assignment where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching assignment, or <code>null</code> if a matching assignment could not be found
	*/
	public static Assignment fetchByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the assignment where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching assignment, or <code>null</code> if a matching assignment could not be found
	*/
	public static Assignment fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the assignment where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the assignment that was removed
	*/
	public static Assignment removeByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.training.gradebook.exception.NoSuchAssignmentException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of assignments where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching assignments
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the assignments where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching assignments
	*/
	public static List<Assignment> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the assignments where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AssignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of assignments
	* @param end the upper bound of the range of assignments (not inclusive)
	* @return the range of matching assignments
	*/
	public static List<Assignment> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the assignments where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AssignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of assignments
	* @param end the upper bound of the range of assignments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching assignments
	*/
	public static List<Assignment> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<Assignment> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the assignments where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AssignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of assignments
	* @param end the upper bound of the range of assignments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching assignments
	*/
	public static List<Assignment> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<Assignment> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first assignment in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching assignment
	* @throws NoSuchAssignmentException if a matching assignment could not be found
	*/
	public static Assignment findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<Assignment> orderByComparator)
		throws com.liferay.training.gradebook.exception.NoSuchAssignmentException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first assignment in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching assignment, or <code>null</code> if a matching assignment could not be found
	*/
	public static Assignment fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<Assignment> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last assignment in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching assignment
	* @throws NoSuchAssignmentException if a matching assignment could not be found
	*/
	public static Assignment findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<Assignment> orderByComparator)
		throws com.liferay.training.gradebook.exception.NoSuchAssignmentException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last assignment in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching assignment, or <code>null</code> if a matching assignment could not be found
	*/
	public static Assignment fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<Assignment> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the assignments before and after the current assignment in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param assignmentId the primary key of the current assignment
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next assignment
	* @throws NoSuchAssignmentException if a assignment with the primary key could not be found
	*/
	public static Assignment[] findByUuid_C_PrevAndNext(long assignmentId,
		java.lang.String uuid, long companyId,
		OrderByComparator<Assignment> orderByComparator)
		throws com.liferay.training.gradebook.exception.NoSuchAssignmentException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(assignmentId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the assignments where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of assignments where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching assignments
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the assignments where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching assignments
	*/
	public static List<Assignment> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the assignments where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AssignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of assignments
	* @param end the upper bound of the range of assignments (not inclusive)
	* @return the range of matching assignments
	*/
	public static List<Assignment> findByGroupId(long groupId, int start,
		int end) {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the assignments where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AssignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of assignments
	* @param end the upper bound of the range of assignments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching assignments
	*/
	public static List<Assignment> findByGroupId(long groupId, int start,
		int end, OrderByComparator<Assignment> orderByComparator) {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the assignments where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AssignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of assignments
	* @param end the upper bound of the range of assignments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching assignments
	*/
	public static List<Assignment> findByGroupId(long groupId, int start,
		int end, OrderByComparator<Assignment> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first assignment in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching assignment
	* @throws NoSuchAssignmentException if a matching assignment could not be found
	*/
	public static Assignment findByGroupId_First(long groupId,
		OrderByComparator<Assignment> orderByComparator)
		throws com.liferay.training.gradebook.exception.NoSuchAssignmentException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first assignment in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching assignment, or <code>null</code> if a matching assignment could not be found
	*/
	public static Assignment fetchByGroupId_First(long groupId,
		OrderByComparator<Assignment> orderByComparator) {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last assignment in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching assignment
	* @throws NoSuchAssignmentException if a matching assignment could not be found
	*/
	public static Assignment findByGroupId_Last(long groupId,
		OrderByComparator<Assignment> orderByComparator)
		throws com.liferay.training.gradebook.exception.NoSuchAssignmentException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last assignment in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching assignment, or <code>null</code> if a matching assignment could not be found
	*/
	public static Assignment fetchByGroupId_Last(long groupId,
		OrderByComparator<Assignment> orderByComparator) {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the assignments before and after the current assignment in the ordered set where groupId = &#63;.
	*
	* @param assignmentId the primary key of the current assignment
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next assignment
	* @throws NoSuchAssignmentException if a assignment with the primary key could not be found
	*/
	public static Assignment[] findByGroupId_PrevAndNext(long assignmentId,
		long groupId, OrderByComparator<Assignment> orderByComparator)
		throws com.liferay.training.gradebook.exception.NoSuchAssignmentException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(assignmentId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the assignments that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching assignments that the user has permission to view
	*/
	public static List<Assignment> filterFindByGroupId(long groupId) {
		return getPersistence().filterFindByGroupId(groupId);
	}

	/**
	* Returns a range of all the assignments that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AssignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of assignments
	* @param end the upper bound of the range of assignments (not inclusive)
	* @return the range of matching assignments that the user has permission to view
	*/
	public static List<Assignment> filterFindByGroupId(long groupId, int start,
		int end) {
		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the assignments that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AssignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of assignments
	* @param end the upper bound of the range of assignments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching assignments that the user has permission to view
	*/
	public static List<Assignment> filterFindByGroupId(long groupId, int start,
		int end, OrderByComparator<Assignment> orderByComparator) {
		return getPersistence()
				   .filterFindByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the assignments before and after the current assignment in the ordered set of assignments that the user has permission to view where groupId = &#63;.
	*
	* @param assignmentId the primary key of the current assignment
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next assignment
	* @throws NoSuchAssignmentException if a assignment with the primary key could not be found
	*/
	public static Assignment[] filterFindByGroupId_PrevAndNext(
		long assignmentId, long groupId,
		OrderByComparator<Assignment> orderByComparator)
		throws com.liferay.training.gradebook.exception.NoSuchAssignmentException {
		return getPersistence()
				   .filterFindByGroupId_PrevAndNext(assignmentId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the assignments where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of assignments where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching assignments
	*/
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns the number of assignments that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching assignments that the user has permission to view
	*/
	public static int filterCountByGroupId(long groupId) {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	* Returns all the assignments where status = &#63;.
	*
	* @param status the status
	* @return the matching assignments
	*/
	public static List<Assignment> findByStatus(int status) {
		return getPersistence().findByStatus(status);
	}

	/**
	* Returns a range of all the assignments where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AssignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of assignments
	* @param end the upper bound of the range of assignments (not inclusive)
	* @return the range of matching assignments
	*/
	public static List<Assignment> findByStatus(int status, int start, int end) {
		return getPersistence().findByStatus(status, start, end);
	}

	/**
	* Returns an ordered range of all the assignments where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AssignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of assignments
	* @param end the upper bound of the range of assignments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching assignments
	*/
	public static List<Assignment> findByStatus(int status, int start, int end,
		OrderByComparator<Assignment> orderByComparator) {
		return getPersistence()
				   .findByStatus(status, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the assignments where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AssignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of assignments
	* @param end the upper bound of the range of assignments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching assignments
	*/
	public static List<Assignment> findByStatus(int status, int start, int end,
		OrderByComparator<Assignment> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByStatus(status, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first assignment in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching assignment
	* @throws NoSuchAssignmentException if a matching assignment could not be found
	*/
	public static Assignment findByStatus_First(int status,
		OrderByComparator<Assignment> orderByComparator)
		throws com.liferay.training.gradebook.exception.NoSuchAssignmentException {
		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	* Returns the first assignment in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching assignment, or <code>null</code> if a matching assignment could not be found
	*/
	public static Assignment fetchByStatus_First(int status,
		OrderByComparator<Assignment> orderByComparator) {
		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	* Returns the last assignment in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching assignment
	* @throws NoSuchAssignmentException if a matching assignment could not be found
	*/
	public static Assignment findByStatus_Last(int status,
		OrderByComparator<Assignment> orderByComparator)
		throws com.liferay.training.gradebook.exception.NoSuchAssignmentException {
		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	* Returns the last assignment in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching assignment, or <code>null</code> if a matching assignment could not be found
	*/
	public static Assignment fetchByStatus_Last(int status,
		OrderByComparator<Assignment> orderByComparator) {
		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	* Returns the assignments before and after the current assignment in the ordered set where status = &#63;.
	*
	* @param assignmentId the primary key of the current assignment
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next assignment
	* @throws NoSuchAssignmentException if a assignment with the primary key could not be found
	*/
	public static Assignment[] findByStatus_PrevAndNext(long assignmentId,
		int status, OrderByComparator<Assignment> orderByComparator)
		throws com.liferay.training.gradebook.exception.NoSuchAssignmentException {
		return getPersistence()
				   .findByStatus_PrevAndNext(assignmentId, status,
			orderByComparator);
	}

	/**
	* Removes all the assignments where status = &#63; from the database.
	*
	* @param status the status
	*/
	public static void removeByStatus(int status) {
		getPersistence().removeByStatus(status);
	}

	/**
	* Returns the number of assignments where status = &#63;.
	*
	* @param status the status
	* @return the number of matching assignments
	*/
	public static int countByStatus(int status) {
		return getPersistence().countByStatus(status);
	}

	/**
	* Returns all the assignments where status = &#63; and groupId = &#63;.
	*
	* @param status the status
	* @param groupId the group ID
	* @return the matching assignments
	*/
	public static List<Assignment> findByG_S(int status, long groupId) {
		return getPersistence().findByG_S(status, groupId);
	}

	/**
	* Returns a range of all the assignments where status = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AssignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param groupId the group ID
	* @param start the lower bound of the range of assignments
	* @param end the upper bound of the range of assignments (not inclusive)
	* @return the range of matching assignments
	*/
	public static List<Assignment> findByG_S(int status, long groupId,
		int start, int end) {
		return getPersistence().findByG_S(status, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the assignments where status = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AssignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param groupId the group ID
	* @param start the lower bound of the range of assignments
	* @param end the upper bound of the range of assignments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching assignments
	*/
	public static List<Assignment> findByG_S(int status, long groupId,
		int start, int end, OrderByComparator<Assignment> orderByComparator) {
		return getPersistence()
				   .findByG_S(status, groupId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the assignments where status = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AssignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param groupId the group ID
	* @param start the lower bound of the range of assignments
	* @param end the upper bound of the range of assignments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching assignments
	*/
	public static List<Assignment> findByG_S(int status, long groupId,
		int start, int end, OrderByComparator<Assignment> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByG_S(status, groupId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first assignment in the ordered set where status = &#63; and groupId = &#63;.
	*
	* @param status the status
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching assignment
	* @throws NoSuchAssignmentException if a matching assignment could not be found
	*/
	public static Assignment findByG_S_First(int status, long groupId,
		OrderByComparator<Assignment> orderByComparator)
		throws com.liferay.training.gradebook.exception.NoSuchAssignmentException {
		return getPersistence()
				   .findByG_S_First(status, groupId, orderByComparator);
	}

	/**
	* Returns the first assignment in the ordered set where status = &#63; and groupId = &#63;.
	*
	* @param status the status
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching assignment, or <code>null</code> if a matching assignment could not be found
	*/
	public static Assignment fetchByG_S_First(int status, long groupId,
		OrderByComparator<Assignment> orderByComparator) {
		return getPersistence()
				   .fetchByG_S_First(status, groupId, orderByComparator);
	}

	/**
	* Returns the last assignment in the ordered set where status = &#63; and groupId = &#63;.
	*
	* @param status the status
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching assignment
	* @throws NoSuchAssignmentException if a matching assignment could not be found
	*/
	public static Assignment findByG_S_Last(int status, long groupId,
		OrderByComparator<Assignment> orderByComparator)
		throws com.liferay.training.gradebook.exception.NoSuchAssignmentException {
		return getPersistence()
				   .findByG_S_Last(status, groupId, orderByComparator);
	}

	/**
	* Returns the last assignment in the ordered set where status = &#63; and groupId = &#63;.
	*
	* @param status the status
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching assignment, or <code>null</code> if a matching assignment could not be found
	*/
	public static Assignment fetchByG_S_Last(int status, long groupId,
		OrderByComparator<Assignment> orderByComparator) {
		return getPersistence()
				   .fetchByG_S_Last(status, groupId, orderByComparator);
	}

	/**
	* Returns the assignments before and after the current assignment in the ordered set where status = &#63; and groupId = &#63;.
	*
	* @param assignmentId the primary key of the current assignment
	* @param status the status
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next assignment
	* @throws NoSuchAssignmentException if a assignment with the primary key could not be found
	*/
	public static Assignment[] findByG_S_PrevAndNext(long assignmentId,
		int status, long groupId,
		OrderByComparator<Assignment> orderByComparator)
		throws com.liferay.training.gradebook.exception.NoSuchAssignmentException {
		return getPersistence()
				   .findByG_S_PrevAndNext(assignmentId, status, groupId,
			orderByComparator);
	}

	/**
	* Returns all the assignments that the user has permission to view where status = &#63; and groupId = &#63;.
	*
	* @param status the status
	* @param groupId the group ID
	* @return the matching assignments that the user has permission to view
	*/
	public static List<Assignment> filterFindByG_S(int status, long groupId) {
		return getPersistence().filterFindByG_S(status, groupId);
	}

	/**
	* Returns a range of all the assignments that the user has permission to view where status = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AssignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param groupId the group ID
	* @param start the lower bound of the range of assignments
	* @param end the upper bound of the range of assignments (not inclusive)
	* @return the range of matching assignments that the user has permission to view
	*/
	public static List<Assignment> filterFindByG_S(int status, long groupId,
		int start, int end) {
		return getPersistence().filterFindByG_S(status, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the assignments that the user has permissions to view where status = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AssignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param groupId the group ID
	* @param start the lower bound of the range of assignments
	* @param end the upper bound of the range of assignments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching assignments that the user has permission to view
	*/
	public static List<Assignment> filterFindByG_S(int status, long groupId,
		int start, int end, OrderByComparator<Assignment> orderByComparator) {
		return getPersistence()
				   .filterFindByG_S(status, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the assignments before and after the current assignment in the ordered set of assignments that the user has permission to view where status = &#63; and groupId = &#63;.
	*
	* @param assignmentId the primary key of the current assignment
	* @param status the status
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next assignment
	* @throws NoSuchAssignmentException if a assignment with the primary key could not be found
	*/
	public static Assignment[] filterFindByG_S_PrevAndNext(long assignmentId,
		int status, long groupId,
		OrderByComparator<Assignment> orderByComparator)
		throws com.liferay.training.gradebook.exception.NoSuchAssignmentException {
		return getPersistence()
				   .filterFindByG_S_PrevAndNext(assignmentId, status, groupId,
			orderByComparator);
	}

	/**
	* Removes all the assignments where status = &#63; and groupId = &#63; from the database.
	*
	* @param status the status
	* @param groupId the group ID
	*/
	public static void removeByG_S(int status, long groupId) {
		getPersistence().removeByG_S(status, groupId);
	}

	/**
	* Returns the number of assignments where status = &#63; and groupId = &#63;.
	*
	* @param status the status
	* @param groupId the group ID
	* @return the number of matching assignments
	*/
	public static int countByG_S(int status, long groupId) {
		return getPersistence().countByG_S(status, groupId);
	}

	/**
	* Returns the number of assignments that the user has permission to view where status = &#63; and groupId = &#63;.
	*
	* @param status the status
	* @param groupId the group ID
	* @return the number of matching assignments that the user has permission to view
	*/
	public static int filterCountByG_S(int status, long groupId) {
		return getPersistence().filterCountByG_S(status, groupId);
	}

	/**
	* Caches the assignment in the entity cache if it is enabled.
	*
	* @param assignment the assignment
	*/
	public static void cacheResult(Assignment assignment) {
		getPersistence().cacheResult(assignment);
	}

	/**
	* Caches the assignments in the entity cache if it is enabled.
	*
	* @param assignments the assignments
	*/
	public static void cacheResult(List<Assignment> assignments) {
		getPersistence().cacheResult(assignments);
	}

	/**
	* Creates a new assignment with the primary key. Does not add the assignment to the database.
	*
	* @param assignmentId the primary key for the new assignment
	* @return the new assignment
	*/
	public static Assignment create(long assignmentId) {
		return getPersistence().create(assignmentId);
	}

	/**
	* Removes the assignment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param assignmentId the primary key of the assignment
	* @return the assignment that was removed
	* @throws NoSuchAssignmentException if a assignment with the primary key could not be found
	*/
	public static Assignment remove(long assignmentId)
		throws com.liferay.training.gradebook.exception.NoSuchAssignmentException {
		return getPersistence().remove(assignmentId);
	}

	public static Assignment updateImpl(Assignment assignment) {
		return getPersistence().updateImpl(assignment);
	}

	/**
	* Returns the assignment with the primary key or throws a {@link NoSuchAssignmentException} if it could not be found.
	*
	* @param assignmentId the primary key of the assignment
	* @return the assignment
	* @throws NoSuchAssignmentException if a assignment with the primary key could not be found
	*/
	public static Assignment findByPrimaryKey(long assignmentId)
		throws com.liferay.training.gradebook.exception.NoSuchAssignmentException {
		return getPersistence().findByPrimaryKey(assignmentId);
	}

	/**
	* Returns the assignment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param assignmentId the primary key of the assignment
	* @return the assignment, or <code>null</code> if a assignment with the primary key could not be found
	*/
	public static Assignment fetchByPrimaryKey(long assignmentId) {
		return getPersistence().fetchByPrimaryKey(assignmentId);
	}

	public static java.util.Map<java.io.Serializable, Assignment> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the assignments.
	*
	* @return the assignments
	*/
	public static List<Assignment> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the assignments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AssignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of assignments
	* @param end the upper bound of the range of assignments (not inclusive)
	* @return the range of assignments
	*/
	public static List<Assignment> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the assignments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AssignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of assignments
	* @param end the upper bound of the range of assignments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of assignments
	*/
	public static List<Assignment> findAll(int start, int end,
		OrderByComparator<Assignment> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the assignments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AssignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of assignments
	* @param end the upper bound of the range of assignments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of assignments
	*/
	public static List<Assignment> findAll(int start, int end,
		OrderByComparator<Assignment> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the assignments from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of assignments.
	*
	* @return the number of assignments
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static AssignmentPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AssignmentPersistence, AssignmentPersistence> _serviceTracker =
		ServiceTrackerFactory.open(AssignmentPersistence.class);
}