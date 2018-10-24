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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Submission. This utility wraps
 * {@link com.liferay.training.gradebook.service.impl.SubmissionLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SubmissionLocalService
 * @see com.liferay.training.gradebook.service.base.SubmissionLocalServiceBaseImpl
 * @see com.liferay.training.gradebook.service.impl.SubmissionLocalServiceImpl
 * @generated
 */
@ProviderType
public class SubmissionLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.training.gradebook.service.impl.SubmissionLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds a new submissions
	*
	* @param assignmentId
	* @param studentId
	* @param submissionText
	* @param serviceContext
	* @return
	* @throws PortalException
	*/
	public static com.liferay.training.gradebook.model.Submission addSubmission(
		long assignmentId, long studentId, java.lang.String submissionText,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addSubmission(assignmentId, studentId, submissionText,
			serviceContext);
	}

	/**
	* Adds the submission to the database. Also notifies the appropriate model listeners.
	*
	* @param submission the submission
	* @return the submission that was added
	*/
	public static com.liferay.training.gradebook.model.Submission addSubmission(
		com.liferay.training.gradebook.model.Submission submission) {
		return getService().addSubmission(submission);
	}

	/**
	* Creates a new submission with the primary key. Does not add the submission to the database.
	*
	* @param submissionId the primary key for the new submission
	* @return the new submission
	*/
	public static com.liferay.training.gradebook.model.Submission createSubmission(
		long submissionId) {
		return getService().createSubmission(submissionId);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the submission with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param submissionId the primary key of the submission
	* @return the submission that was removed
	* @throws PortalException if a submission with the primary key could not be found
	*/
	public static com.liferay.training.gradebook.model.Submission deleteSubmission(
		long submissionId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteSubmission(submissionId);
	}

	/**
	* Deletes the submission from the database. Also notifies the appropriate model listeners.
	*
	* @param submission the submission
	* @return the submission that was removed
	*/
	public static com.liferay.training.gradebook.model.Submission deleteSubmission(
		com.liferay.training.gradebook.model.Submission submission) {
		return getService().deleteSubmission(submission);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.gradebook.model.impl.SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.gradebook.model.impl.SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.training.gradebook.model.Submission fetchSubmission(
		long submissionId) {
		return getService().fetchSubmission(submissionId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the submission with the primary key.
	*
	* @param submissionId the primary key of the submission
	* @return the submission
	* @throws PortalException if a submission with the primary key could not be found
	*/
	public static com.liferay.training.gradebook.model.Submission getSubmission(
		long submissionId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getSubmission(submissionId);
	}

	/**
	* Returns a range of all the submissions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.gradebook.model.impl.SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of submissions
	* @param end the upper bound of the range of submissions (not inclusive)
	* @return the range of submissions
	*/
	public static java.util.List<com.liferay.training.gradebook.model.Submission> getSubmissions(
		int start, int end) {
		return getService().getSubmissions(start, end);
	}

	public static java.util.List<com.liferay.training.gradebook.model.Submission> getSubmissionsByAssignment(
		long groupId, long assignmentId) {
		return getService().getSubmissionsByAssignment(groupId, assignmentId);
	}

	public static java.util.List<com.liferay.training.gradebook.model.Submission> getSubmissionsByAssignment(
		long groupId, long assignmentId, int start, int end) {
		return getService()
				   .getSubmissionsByAssignment(groupId, assignmentId, start, end);
	}

	/**
	* Gets submissions by keywords.
	*
	* This example uses dynamic queries.
	*
	* @param groupId
	* @param assignmentId
	* @param keywords
	* @param start
	* @param end
	* @param orderByComparator
	* @return
	*/
	public static java.util.List<com.liferay.training.gradebook.model.Submission> getSubmissionsByKeywords(
		long groupId, long assignmentId, java.lang.String keywords, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.training.gradebook.model.Submission> orderByComparator) {
		return getService()
				   .getSubmissionsByKeywords(groupId, assignmentId, keywords,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of submissions.
	*
	* @return the number of submissions
	*/
	public static int getSubmissionsCount() {
		return getService().getSubmissionsCount();
	}

	public static int getSubmissionsCountByAssignment(long groupId,
		long assignmentId) {
		return getService()
				   .getSubmissionsCountByAssignment(groupId, assignmentId);
	}

	public static long getSubmissionsCountByKeywords(long groupId,
		long assignmentId, java.lang.String keywords) {
		return getService()
				   .getSubmissionsCountByKeywords(groupId, assignmentId,
			keywords);
	}

	public static com.liferay.training.gradebook.model.Submission gradeAndCommentSubmission(
		long submissionId, int grade, java.lang.String comment)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .gradeAndCommentSubmission(submissionId, grade, comment);
	}

	/**
	* Grades submission.
	*
	* @param submissionId
	* @param grade
	* @return
	* @throws PortalException
	*/
	public static com.liferay.training.gradebook.model.Submission gradeSubmission(
		long submissionId, int grade)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().gradeSubmission(submissionId, grade);
	}

	/**
	* Updates submission.
	*
	* @param submissionId
	* @param submissionText
	* @param serviceContext
	* @return
	* @throws PortalException
	*/
	public static com.liferay.training.gradebook.model.Submission updateSubmission(
		long submissionId, java.lang.String submissionText,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateSubmission(submissionId, submissionText,
			serviceContext);
	}

	/**
	* Updates the submission in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param submission the submission
	* @return the submission that was updated
	*/
	public static com.liferay.training.gradebook.model.Submission updateSubmission(
		com.liferay.training.gradebook.model.Submission submission) {
		return getService().updateSubmission(submission);
	}

	public static SubmissionLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SubmissionLocalService, SubmissionLocalService> _serviceTracker =
		ServiceTrackerFactory.open(SubmissionLocalService.class);
}