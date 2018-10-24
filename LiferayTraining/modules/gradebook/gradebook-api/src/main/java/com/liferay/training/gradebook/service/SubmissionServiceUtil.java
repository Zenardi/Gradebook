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
 * Provides the remote service utility for Submission. This utility wraps
 * {@link com.liferay.training.gradebook.service.impl.SubmissionServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see SubmissionService
 * @see com.liferay.training.gradebook.service.base.SubmissionServiceBaseImpl
 * @see com.liferay.training.gradebook.service.impl.SubmissionServiceImpl
 * @generated
 */
@ProviderType
public class SubmissionServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.training.gradebook.service.impl.SubmissionServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.training.gradebook.model.Submission addSubmission(
		long assignmentId, long studentId, java.lang.String submissionText,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addSubmission(assignmentId, studentId, submissionText,
			serviceContext);
	}

	public static com.liferay.training.gradebook.model.Submission deleteSubmission(
		long submissionId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteSubmission(submissionId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
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

	public static java.util.List<com.liferay.training.gradebook.model.Submission> getSubmissionsByKeywords(
		long groupId, long assignmentId, java.lang.String keywords, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.training.gradebook.model.Submission> orderByComparator) {
		return getService()
				   .getSubmissionsByKeywords(groupId, assignmentId, keywords,
			start, end, orderByComparator);
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

	public static com.liferay.training.gradebook.model.Submission gradeSubmission(
		long submissionId, int grade)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().gradeSubmission(submissionId, grade);
	}

	public static com.liferay.training.gradebook.model.Submission updateSubmission(
		long submissionId, java.lang.String submissionText,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateSubmission(submissionId, submissionText,
			serviceContext);
	}

	public static SubmissionService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SubmissionService, SubmissionService> _serviceTracker =
		ServiceTrackerFactory.open(SubmissionService.class);
}