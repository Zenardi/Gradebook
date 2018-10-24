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

import com.liferay.training.gradebook.exception.NoSuchSubmissionException;
import com.liferay.training.gradebook.model.Submission;

/**
 * The persistence interface for the submission service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.training.gradebook.service.persistence.impl.SubmissionPersistenceImpl
 * @see SubmissionUtil
 * @generated
 */
@ProviderType
public interface SubmissionPersistence extends BasePersistence<Submission> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SubmissionUtil} to access the submission persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the submissions where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching submissions
	*/
	public java.util.List<Submission> findByGroupId(long groupId);

	/**
	* Returns a range of all the submissions where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of submissions
	* @param end the upper bound of the range of submissions (not inclusive)
	* @return the range of matching submissions
	*/
	public java.util.List<Submission> findByGroupId(long groupId, int start,
		int end);

	/**
	* Returns an ordered range of all the submissions where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of submissions
	* @param end the upper bound of the range of submissions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching submissions
	*/
	public java.util.List<Submission> findByGroupId(long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Submission> orderByComparator);

	/**
	* Returns an ordered range of all the submissions where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of submissions
	* @param end the upper bound of the range of submissions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching submissions
	*/
	public java.util.List<Submission> findByGroupId(long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Submission> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first submission in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission
	* @throws NoSuchSubmissionException if a matching submission could not be found
	*/
	public Submission findByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Submission> orderByComparator)
		throws NoSuchSubmissionException;

	/**
	* Returns the first submission in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission, or <code>null</code> if a matching submission could not be found
	*/
	public Submission fetchByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Submission> orderByComparator);

	/**
	* Returns the last submission in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission
	* @throws NoSuchSubmissionException if a matching submission could not be found
	*/
	public Submission findByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Submission> orderByComparator)
		throws NoSuchSubmissionException;

	/**
	* Returns the last submission in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission, or <code>null</code> if a matching submission could not be found
	*/
	public Submission fetchByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Submission> orderByComparator);

	/**
	* Returns the submissions before and after the current submission in the ordered set where groupId = &#63;.
	*
	* @param submissionId the primary key of the current submission
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next submission
	* @throws NoSuchSubmissionException if a submission with the primary key could not be found
	*/
	public Submission[] findByGroupId_PrevAndNext(long submissionId,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Submission> orderByComparator)
		throws NoSuchSubmissionException;

	/**
	* Removes all the submissions where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public void removeByGroupId(long groupId);

	/**
	* Returns the number of submissions where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching submissions
	*/
	public int countByGroupId(long groupId);

	/**
	* Returns all the submissions where groupId = &#63; and assignmentId = &#63;.
	*
	* @param groupId the group ID
	* @param assignmentId the assignment ID
	* @return the matching submissions
	*/
	public java.util.List<Submission> findByG_A(long groupId, long assignmentId);

	/**
	* Returns a range of all the submissions where groupId = &#63; and assignmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param assignmentId the assignment ID
	* @param start the lower bound of the range of submissions
	* @param end the upper bound of the range of submissions (not inclusive)
	* @return the range of matching submissions
	*/
	public java.util.List<Submission> findByG_A(long groupId,
		long assignmentId, int start, int end);

	/**
	* Returns an ordered range of all the submissions where groupId = &#63; and assignmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param assignmentId the assignment ID
	* @param start the lower bound of the range of submissions
	* @param end the upper bound of the range of submissions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching submissions
	*/
	public java.util.List<Submission> findByG_A(long groupId,
		long assignmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Submission> orderByComparator);

	/**
	* Returns an ordered range of all the submissions where groupId = &#63; and assignmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param assignmentId the assignment ID
	* @param start the lower bound of the range of submissions
	* @param end the upper bound of the range of submissions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching submissions
	*/
	public java.util.List<Submission> findByG_A(long groupId,
		long assignmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Submission> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first submission in the ordered set where groupId = &#63; and assignmentId = &#63;.
	*
	* @param groupId the group ID
	* @param assignmentId the assignment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission
	* @throws NoSuchSubmissionException if a matching submission could not be found
	*/
	public Submission findByG_A_First(long groupId, long assignmentId,
		com.liferay.portal.kernel.util.OrderByComparator<Submission> orderByComparator)
		throws NoSuchSubmissionException;

	/**
	* Returns the first submission in the ordered set where groupId = &#63; and assignmentId = &#63;.
	*
	* @param groupId the group ID
	* @param assignmentId the assignment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission, or <code>null</code> if a matching submission could not be found
	*/
	public Submission fetchByG_A_First(long groupId, long assignmentId,
		com.liferay.portal.kernel.util.OrderByComparator<Submission> orderByComparator);

	/**
	* Returns the last submission in the ordered set where groupId = &#63; and assignmentId = &#63;.
	*
	* @param groupId the group ID
	* @param assignmentId the assignment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission
	* @throws NoSuchSubmissionException if a matching submission could not be found
	*/
	public Submission findByG_A_Last(long groupId, long assignmentId,
		com.liferay.portal.kernel.util.OrderByComparator<Submission> orderByComparator)
		throws NoSuchSubmissionException;

	/**
	* Returns the last submission in the ordered set where groupId = &#63; and assignmentId = &#63;.
	*
	* @param groupId the group ID
	* @param assignmentId the assignment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission, or <code>null</code> if a matching submission could not be found
	*/
	public Submission fetchByG_A_Last(long groupId, long assignmentId,
		com.liferay.portal.kernel.util.OrderByComparator<Submission> orderByComparator);

	/**
	* Returns the submissions before and after the current submission in the ordered set where groupId = &#63; and assignmentId = &#63;.
	*
	* @param submissionId the primary key of the current submission
	* @param groupId the group ID
	* @param assignmentId the assignment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next submission
	* @throws NoSuchSubmissionException if a submission with the primary key could not be found
	*/
	public Submission[] findByG_A_PrevAndNext(long submissionId, long groupId,
		long assignmentId,
		com.liferay.portal.kernel.util.OrderByComparator<Submission> orderByComparator)
		throws NoSuchSubmissionException;

	/**
	* Removes all the submissions where groupId = &#63; and assignmentId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param assignmentId the assignment ID
	*/
	public void removeByG_A(long groupId, long assignmentId);

	/**
	* Returns the number of submissions where groupId = &#63; and assignmentId = &#63;.
	*
	* @param groupId the group ID
	* @param assignmentId the assignment ID
	* @return the number of matching submissions
	*/
	public int countByG_A(long groupId, long assignmentId);

	/**
	* Returns all the submissions where studentId = &#63;.
	*
	* @param studentId the student ID
	* @return the matching submissions
	*/
	public java.util.List<Submission> findByStudentId(long studentId);

	/**
	* Returns a range of all the submissions where studentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param studentId the student ID
	* @param start the lower bound of the range of submissions
	* @param end the upper bound of the range of submissions (not inclusive)
	* @return the range of matching submissions
	*/
	public java.util.List<Submission> findByStudentId(long studentId,
		int start, int end);

	/**
	* Returns an ordered range of all the submissions where studentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param studentId the student ID
	* @param start the lower bound of the range of submissions
	* @param end the upper bound of the range of submissions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching submissions
	*/
	public java.util.List<Submission> findByStudentId(long studentId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Submission> orderByComparator);

	/**
	* Returns an ordered range of all the submissions where studentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param studentId the student ID
	* @param start the lower bound of the range of submissions
	* @param end the upper bound of the range of submissions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching submissions
	*/
	public java.util.List<Submission> findByStudentId(long studentId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Submission> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first submission in the ordered set where studentId = &#63;.
	*
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission
	* @throws NoSuchSubmissionException if a matching submission could not be found
	*/
	public Submission findByStudentId_First(long studentId,
		com.liferay.portal.kernel.util.OrderByComparator<Submission> orderByComparator)
		throws NoSuchSubmissionException;

	/**
	* Returns the first submission in the ordered set where studentId = &#63;.
	*
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission, or <code>null</code> if a matching submission could not be found
	*/
	public Submission fetchByStudentId_First(long studentId,
		com.liferay.portal.kernel.util.OrderByComparator<Submission> orderByComparator);

	/**
	* Returns the last submission in the ordered set where studentId = &#63;.
	*
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission
	* @throws NoSuchSubmissionException if a matching submission could not be found
	*/
	public Submission findByStudentId_Last(long studentId,
		com.liferay.portal.kernel.util.OrderByComparator<Submission> orderByComparator)
		throws NoSuchSubmissionException;

	/**
	* Returns the last submission in the ordered set where studentId = &#63;.
	*
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission, or <code>null</code> if a matching submission could not be found
	*/
	public Submission fetchByStudentId_Last(long studentId,
		com.liferay.portal.kernel.util.OrderByComparator<Submission> orderByComparator);

	/**
	* Returns the submissions before and after the current submission in the ordered set where studentId = &#63;.
	*
	* @param submissionId the primary key of the current submission
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next submission
	* @throws NoSuchSubmissionException if a submission with the primary key could not be found
	*/
	public Submission[] findByStudentId_PrevAndNext(long submissionId,
		long studentId,
		com.liferay.portal.kernel.util.OrderByComparator<Submission> orderByComparator)
		throws NoSuchSubmissionException;

	/**
	* Removes all the submissions where studentId = &#63; from the database.
	*
	* @param studentId the student ID
	*/
	public void removeByStudentId(long studentId);

	/**
	* Returns the number of submissions where studentId = &#63;.
	*
	* @param studentId the student ID
	* @return the number of matching submissions
	*/
	public int countByStudentId(long studentId);

	/**
	* Returns all the submissions where studentId = &#63; and assignmentId = &#63;.
	*
	* @param studentId the student ID
	* @param assignmentId the assignment ID
	* @return the matching submissions
	*/
	public java.util.List<Submission> findByStudentIdAssignmentId(
		long studentId, long assignmentId);

	/**
	* Returns a range of all the submissions where studentId = &#63; and assignmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param studentId the student ID
	* @param assignmentId the assignment ID
	* @param start the lower bound of the range of submissions
	* @param end the upper bound of the range of submissions (not inclusive)
	* @return the range of matching submissions
	*/
	public java.util.List<Submission> findByStudentIdAssignmentId(
		long studentId, long assignmentId, int start, int end);

	/**
	* Returns an ordered range of all the submissions where studentId = &#63; and assignmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param studentId the student ID
	* @param assignmentId the assignment ID
	* @param start the lower bound of the range of submissions
	* @param end the upper bound of the range of submissions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching submissions
	*/
	public java.util.List<Submission> findByStudentIdAssignmentId(
		long studentId, long assignmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Submission> orderByComparator);

	/**
	* Returns an ordered range of all the submissions where studentId = &#63; and assignmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param studentId the student ID
	* @param assignmentId the assignment ID
	* @param start the lower bound of the range of submissions
	* @param end the upper bound of the range of submissions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching submissions
	*/
	public java.util.List<Submission> findByStudentIdAssignmentId(
		long studentId, long assignmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Submission> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first submission in the ordered set where studentId = &#63; and assignmentId = &#63;.
	*
	* @param studentId the student ID
	* @param assignmentId the assignment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission
	* @throws NoSuchSubmissionException if a matching submission could not be found
	*/
	public Submission findByStudentIdAssignmentId_First(long studentId,
		long assignmentId,
		com.liferay.portal.kernel.util.OrderByComparator<Submission> orderByComparator)
		throws NoSuchSubmissionException;

	/**
	* Returns the first submission in the ordered set where studentId = &#63; and assignmentId = &#63;.
	*
	* @param studentId the student ID
	* @param assignmentId the assignment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission, or <code>null</code> if a matching submission could not be found
	*/
	public Submission fetchByStudentIdAssignmentId_First(long studentId,
		long assignmentId,
		com.liferay.portal.kernel.util.OrderByComparator<Submission> orderByComparator);

	/**
	* Returns the last submission in the ordered set where studentId = &#63; and assignmentId = &#63;.
	*
	* @param studentId the student ID
	* @param assignmentId the assignment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission
	* @throws NoSuchSubmissionException if a matching submission could not be found
	*/
	public Submission findByStudentIdAssignmentId_Last(long studentId,
		long assignmentId,
		com.liferay.portal.kernel.util.OrderByComparator<Submission> orderByComparator)
		throws NoSuchSubmissionException;

	/**
	* Returns the last submission in the ordered set where studentId = &#63; and assignmentId = &#63;.
	*
	* @param studentId the student ID
	* @param assignmentId the assignment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission, or <code>null</code> if a matching submission could not be found
	*/
	public Submission fetchByStudentIdAssignmentId_Last(long studentId,
		long assignmentId,
		com.liferay.portal.kernel.util.OrderByComparator<Submission> orderByComparator);

	/**
	* Returns the submissions before and after the current submission in the ordered set where studentId = &#63; and assignmentId = &#63;.
	*
	* @param submissionId the primary key of the current submission
	* @param studentId the student ID
	* @param assignmentId the assignment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next submission
	* @throws NoSuchSubmissionException if a submission with the primary key could not be found
	*/
	public Submission[] findByStudentIdAssignmentId_PrevAndNext(
		long submissionId, long studentId, long assignmentId,
		com.liferay.portal.kernel.util.OrderByComparator<Submission> orderByComparator)
		throws NoSuchSubmissionException;

	/**
	* Removes all the submissions where studentId = &#63; and assignmentId = &#63; from the database.
	*
	* @param studentId the student ID
	* @param assignmentId the assignment ID
	*/
	public void removeByStudentIdAssignmentId(long studentId, long assignmentId);

	/**
	* Returns the number of submissions where studentId = &#63; and assignmentId = &#63;.
	*
	* @param studentId the student ID
	* @param assignmentId the assignment ID
	* @return the number of matching submissions
	*/
	public int countByStudentIdAssignmentId(long studentId, long assignmentId);

	/**
	* Caches the submission in the entity cache if it is enabled.
	*
	* @param submission the submission
	*/
	public void cacheResult(Submission submission);

	/**
	* Caches the submissions in the entity cache if it is enabled.
	*
	* @param submissions the submissions
	*/
	public void cacheResult(java.util.List<Submission> submissions);

	/**
	* Creates a new submission with the primary key. Does not add the submission to the database.
	*
	* @param submissionId the primary key for the new submission
	* @return the new submission
	*/
	public Submission create(long submissionId);

	/**
	* Removes the submission with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param submissionId the primary key of the submission
	* @return the submission that was removed
	* @throws NoSuchSubmissionException if a submission with the primary key could not be found
	*/
	public Submission remove(long submissionId)
		throws NoSuchSubmissionException;

	public Submission updateImpl(Submission submission);

	/**
	* Returns the submission with the primary key or throws a {@link NoSuchSubmissionException} if it could not be found.
	*
	* @param submissionId the primary key of the submission
	* @return the submission
	* @throws NoSuchSubmissionException if a submission with the primary key could not be found
	*/
	public Submission findByPrimaryKey(long submissionId)
		throws NoSuchSubmissionException;

	/**
	* Returns the submission with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param submissionId the primary key of the submission
	* @return the submission, or <code>null</code> if a submission with the primary key could not be found
	*/
	public Submission fetchByPrimaryKey(long submissionId);

	@Override
	public java.util.Map<java.io.Serializable, Submission> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the submissions.
	*
	* @return the submissions
	*/
	public java.util.List<Submission> findAll();

	/**
	* Returns a range of all the submissions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of submissions
	* @param end the upper bound of the range of submissions (not inclusive)
	* @return the range of submissions
	*/
	public java.util.List<Submission> findAll(int start, int end);

	/**
	* Returns an ordered range of all the submissions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of submissions
	* @param end the upper bound of the range of submissions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of submissions
	*/
	public java.util.List<Submission> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Submission> orderByComparator);

	/**
	* Returns an ordered range of all the submissions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of submissions
	* @param end the upper bound of the range of submissions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of submissions
	*/
	public java.util.List<Submission> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Submission> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the submissions from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of submissions.
	*
	* @return the number of submissions
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}