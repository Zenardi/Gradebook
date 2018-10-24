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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.liferay.training.gradebook.exception.NoSuchAssignmentException;
import com.liferay.training.gradebook.model.Assignment;

/**
 * The persistence interface for the assignment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.training.gradebook.service.persistence.impl.AssignmentPersistenceImpl
 * @see AssignmentUtil
 * @generated
 */
@ProviderType
public interface AssignmentPersistence extends BasePersistence<Assignment> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AssignmentUtil} to access the assignment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the assignments where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching assignments
	*/
	public java.util.List<Assignment> findByUuid(java.lang.String uuid);

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
	public java.util.List<Assignment> findByUuid(java.lang.String uuid,
		int start, int end);

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
	public java.util.List<Assignment> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Assignment> orderByComparator);

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
	public java.util.List<Assignment> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Assignment> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first assignment in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching assignment
	* @throws NoSuchAssignmentException if a matching assignment could not be found
	*/
	public Assignment findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Assignment> orderByComparator)
		throws NoSuchAssignmentException;

	/**
	* Returns the first assignment in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching assignment, or <code>null</code> if a matching assignment could not be found
	*/
	public Assignment fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Assignment> orderByComparator);

	/**
	* Returns the last assignment in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching assignment
	* @throws NoSuchAssignmentException if a matching assignment could not be found
	*/
	public Assignment findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Assignment> orderByComparator)
		throws NoSuchAssignmentException;

	/**
	* Returns the last assignment in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching assignment, or <code>null</code> if a matching assignment could not be found
	*/
	public Assignment fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Assignment> orderByComparator);

	/**
	* Returns the assignments before and after the current assignment in the ordered set where uuid = &#63;.
	*
	* @param assignmentId the primary key of the current assignment
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next assignment
	* @throws NoSuchAssignmentException if a assignment with the primary key could not be found
	*/
	public Assignment[] findByUuid_PrevAndNext(long assignmentId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Assignment> orderByComparator)
		throws NoSuchAssignmentException;

	/**
	* Removes all the assignments where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of assignments where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching assignments
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the assignment where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchAssignmentException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching assignment
	* @throws NoSuchAssignmentException if a matching assignment could not be found
	*/
	public Assignment findByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchAssignmentException;

	/**
	* Returns the assignment where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching assignment, or <code>null</code> if a matching assignment could not be found
	*/
	public Assignment fetchByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns the assignment where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching assignment, or <code>null</code> if a matching assignment could not be found
	*/
	public Assignment fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the assignment where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the assignment that was removed
	*/
	public Assignment removeByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchAssignmentException;

	/**
	* Returns the number of assignments where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching assignments
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the assignments where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching assignments
	*/
	public java.util.List<Assignment> findByUuid_C(java.lang.String uuid,
		long companyId);

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
	public java.util.List<Assignment> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

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
	public java.util.List<Assignment> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Assignment> orderByComparator);

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
	public java.util.List<Assignment> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Assignment> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first assignment in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching assignment
	* @throws NoSuchAssignmentException if a matching assignment could not be found
	*/
	public Assignment findByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Assignment> orderByComparator)
		throws NoSuchAssignmentException;

	/**
	* Returns the first assignment in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching assignment, or <code>null</code> if a matching assignment could not be found
	*/
	public Assignment fetchByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Assignment> orderByComparator);

	/**
	* Returns the last assignment in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching assignment
	* @throws NoSuchAssignmentException if a matching assignment could not be found
	*/
	public Assignment findByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Assignment> orderByComparator)
		throws NoSuchAssignmentException;

	/**
	* Returns the last assignment in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching assignment, or <code>null</code> if a matching assignment could not be found
	*/
	public Assignment fetchByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Assignment> orderByComparator);

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
	public Assignment[] findByUuid_C_PrevAndNext(long assignmentId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Assignment> orderByComparator)
		throws NoSuchAssignmentException;

	/**
	* Removes all the assignments where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of assignments where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching assignments
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the assignments where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching assignments
	*/
	public java.util.List<Assignment> findByGroupId(long groupId);

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
	public java.util.List<Assignment> findByGroupId(long groupId, int start,
		int end);

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
	public java.util.List<Assignment> findByGroupId(long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Assignment> orderByComparator);

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
	public java.util.List<Assignment> findByGroupId(long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Assignment> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first assignment in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching assignment
	* @throws NoSuchAssignmentException if a matching assignment could not be found
	*/
	public Assignment findByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Assignment> orderByComparator)
		throws NoSuchAssignmentException;

	/**
	* Returns the first assignment in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching assignment, or <code>null</code> if a matching assignment could not be found
	*/
	public Assignment fetchByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Assignment> orderByComparator);

	/**
	* Returns the last assignment in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching assignment
	* @throws NoSuchAssignmentException if a matching assignment could not be found
	*/
	public Assignment findByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Assignment> orderByComparator)
		throws NoSuchAssignmentException;

	/**
	* Returns the last assignment in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching assignment, or <code>null</code> if a matching assignment could not be found
	*/
	public Assignment fetchByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Assignment> orderByComparator);

	/**
	* Returns the assignments before and after the current assignment in the ordered set where groupId = &#63;.
	*
	* @param assignmentId the primary key of the current assignment
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next assignment
	* @throws NoSuchAssignmentException if a assignment with the primary key could not be found
	*/
	public Assignment[] findByGroupId_PrevAndNext(long assignmentId,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Assignment> orderByComparator)
		throws NoSuchAssignmentException;

	/**
	* Returns all the assignments that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching assignments that the user has permission to view
	*/
	public java.util.List<Assignment> filterFindByGroupId(long groupId);

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
	public java.util.List<Assignment> filterFindByGroupId(long groupId,
		int start, int end);

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
	public java.util.List<Assignment> filterFindByGroupId(long groupId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Assignment> orderByComparator);

	/**
	* Returns the assignments before and after the current assignment in the ordered set of assignments that the user has permission to view where groupId = &#63;.
	*
	* @param assignmentId the primary key of the current assignment
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next assignment
	* @throws NoSuchAssignmentException if a assignment with the primary key could not be found
	*/
	public Assignment[] filterFindByGroupId_PrevAndNext(long assignmentId,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Assignment> orderByComparator)
		throws NoSuchAssignmentException;

	/**
	* Removes all the assignments where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public void removeByGroupId(long groupId);

	/**
	* Returns the number of assignments where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching assignments
	*/
	public int countByGroupId(long groupId);

	/**
	* Returns the number of assignments that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching assignments that the user has permission to view
	*/
	public int filterCountByGroupId(long groupId);

	/**
	* Returns all the assignments where status = &#63;.
	*
	* @param status the status
	* @return the matching assignments
	*/
	public java.util.List<Assignment> findByStatus(int status);

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
	public java.util.List<Assignment> findByStatus(int status, int start,
		int end);

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
	public java.util.List<Assignment> findByStatus(int status, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Assignment> orderByComparator);

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
	public java.util.List<Assignment> findByStatus(int status, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Assignment> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first assignment in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching assignment
	* @throws NoSuchAssignmentException if a matching assignment could not be found
	*/
	public Assignment findByStatus_First(int status,
		com.liferay.portal.kernel.util.OrderByComparator<Assignment> orderByComparator)
		throws NoSuchAssignmentException;

	/**
	* Returns the first assignment in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching assignment, or <code>null</code> if a matching assignment could not be found
	*/
	public Assignment fetchByStatus_First(int status,
		com.liferay.portal.kernel.util.OrderByComparator<Assignment> orderByComparator);

	/**
	* Returns the last assignment in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching assignment
	* @throws NoSuchAssignmentException if a matching assignment could not be found
	*/
	public Assignment findByStatus_Last(int status,
		com.liferay.portal.kernel.util.OrderByComparator<Assignment> orderByComparator)
		throws NoSuchAssignmentException;

	/**
	* Returns the last assignment in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching assignment, or <code>null</code> if a matching assignment could not be found
	*/
	public Assignment fetchByStatus_Last(int status,
		com.liferay.portal.kernel.util.OrderByComparator<Assignment> orderByComparator);

	/**
	* Returns the assignments before and after the current assignment in the ordered set where status = &#63;.
	*
	* @param assignmentId the primary key of the current assignment
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next assignment
	* @throws NoSuchAssignmentException if a assignment with the primary key could not be found
	*/
	public Assignment[] findByStatus_PrevAndNext(long assignmentId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Assignment> orderByComparator)
		throws NoSuchAssignmentException;

	/**
	* Removes all the assignments where status = &#63; from the database.
	*
	* @param status the status
	*/
	public void removeByStatus(int status);

	/**
	* Returns the number of assignments where status = &#63;.
	*
	* @param status the status
	* @return the number of matching assignments
	*/
	public int countByStatus(int status);

	/**
	* Returns all the assignments where status = &#63; and groupId = &#63;.
	*
	* @param status the status
	* @param groupId the group ID
	* @return the matching assignments
	*/
	public java.util.List<Assignment> findByG_S(int status, long groupId);

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
	public java.util.List<Assignment> findByG_S(int status, long groupId,
		int start, int end);

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
	public java.util.List<Assignment> findByG_S(int status, long groupId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Assignment> orderByComparator);

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
	public java.util.List<Assignment> findByG_S(int status, long groupId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Assignment> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first assignment in the ordered set where status = &#63; and groupId = &#63;.
	*
	* @param status the status
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching assignment
	* @throws NoSuchAssignmentException if a matching assignment could not be found
	*/
	public Assignment findByG_S_First(int status, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Assignment> orderByComparator)
		throws NoSuchAssignmentException;

	/**
	* Returns the first assignment in the ordered set where status = &#63; and groupId = &#63;.
	*
	* @param status the status
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching assignment, or <code>null</code> if a matching assignment could not be found
	*/
	public Assignment fetchByG_S_First(int status, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Assignment> orderByComparator);

	/**
	* Returns the last assignment in the ordered set where status = &#63; and groupId = &#63;.
	*
	* @param status the status
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching assignment
	* @throws NoSuchAssignmentException if a matching assignment could not be found
	*/
	public Assignment findByG_S_Last(int status, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Assignment> orderByComparator)
		throws NoSuchAssignmentException;

	/**
	* Returns the last assignment in the ordered set where status = &#63; and groupId = &#63;.
	*
	* @param status the status
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching assignment, or <code>null</code> if a matching assignment could not be found
	*/
	public Assignment fetchByG_S_Last(int status, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Assignment> orderByComparator);

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
	public Assignment[] findByG_S_PrevAndNext(long assignmentId, int status,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Assignment> orderByComparator)
		throws NoSuchAssignmentException;

	/**
	* Returns all the assignments that the user has permission to view where status = &#63; and groupId = &#63;.
	*
	* @param status the status
	* @param groupId the group ID
	* @return the matching assignments that the user has permission to view
	*/
	public java.util.List<Assignment> filterFindByG_S(int status, long groupId);

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
	public java.util.List<Assignment> filterFindByG_S(int status, long groupId,
		int start, int end);

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
	public java.util.List<Assignment> filterFindByG_S(int status, long groupId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Assignment> orderByComparator);

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
	public Assignment[] filterFindByG_S_PrevAndNext(long assignmentId,
		int status, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Assignment> orderByComparator)
		throws NoSuchAssignmentException;

	/**
	* Removes all the assignments where status = &#63; and groupId = &#63; from the database.
	*
	* @param status the status
	* @param groupId the group ID
	*/
	public void removeByG_S(int status, long groupId);

	/**
	* Returns the number of assignments where status = &#63; and groupId = &#63;.
	*
	* @param status the status
	* @param groupId the group ID
	* @return the number of matching assignments
	*/
	public int countByG_S(int status, long groupId);

	/**
	* Returns the number of assignments that the user has permission to view where status = &#63; and groupId = &#63;.
	*
	* @param status the status
	* @param groupId the group ID
	* @return the number of matching assignments that the user has permission to view
	*/
	public int filterCountByG_S(int status, long groupId);

	/**
	* Caches the assignment in the entity cache if it is enabled.
	*
	* @param assignment the assignment
	*/
	public void cacheResult(Assignment assignment);

	/**
	* Caches the assignments in the entity cache if it is enabled.
	*
	* @param assignments the assignments
	*/
	public void cacheResult(java.util.List<Assignment> assignments);

	/**
	* Creates a new assignment with the primary key. Does not add the assignment to the database.
	*
	* @param assignmentId the primary key for the new assignment
	* @return the new assignment
	*/
	public Assignment create(long assignmentId);

	/**
	* Removes the assignment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param assignmentId the primary key of the assignment
	* @return the assignment that was removed
	* @throws NoSuchAssignmentException if a assignment with the primary key could not be found
	*/
	public Assignment remove(long assignmentId)
		throws NoSuchAssignmentException;

	public Assignment updateImpl(Assignment assignment);

	/**
	* Returns the assignment with the primary key or throws a {@link NoSuchAssignmentException} if it could not be found.
	*
	* @param assignmentId the primary key of the assignment
	* @return the assignment
	* @throws NoSuchAssignmentException if a assignment with the primary key could not be found
	*/
	public Assignment findByPrimaryKey(long assignmentId)
		throws NoSuchAssignmentException;

	/**
	* Returns the assignment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param assignmentId the primary key of the assignment
	* @return the assignment, or <code>null</code> if a assignment with the primary key could not be found
	*/
	public Assignment fetchByPrimaryKey(long assignmentId);

	@Override
	public java.util.Map<java.io.Serializable, Assignment> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the assignments.
	*
	* @return the assignments
	*/
	public java.util.List<Assignment> findAll();

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
	public java.util.List<Assignment> findAll(int start, int end);

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
	public java.util.List<Assignment> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Assignment> orderByComparator);

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
	public java.util.List<Assignment> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Assignment> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the assignments from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of assignments.
	*
	* @return the number of assignments
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}