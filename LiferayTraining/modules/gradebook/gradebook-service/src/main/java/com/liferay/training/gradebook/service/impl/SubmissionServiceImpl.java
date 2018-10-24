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

import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.training.gradebook.model.Assignment;
import com.liferay.training.gradebook.model.Submission;
import com.liferay.training.gradebook.service.base.SubmissionServiceBaseImpl;

/**
 * The implementation of the submission remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.training.gradebook.service.SubmissionService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SubmissionServiceBaseImpl
 * @see com.liferay.training.gradebook.service.SubmissionServiceUtil
 */
public class SubmissionServiceImpl extends SubmissionServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.training.gradebook.service.SubmissionServiceUtil} to access the submission remote service.
	 */
	
	
	public Submission addSubmission(long assignmentId, long studentId, String submissionText, ServiceContext serviceContext) throws PortalException {

		// TODO: Add permission checking
		
		return submissionLocalService.addSubmission(assignmentId, studentId, submissionText, serviceContext);
	}
		
	public Submission deleteSubmission(long submissionId) throws PortalException {
		
		// TODO: Add permission checking
		
		return submissionLocalService.deleteSubmission(submissionId);
	}
	
	public Submission gradeSubmission(long submissionId, int grade) throws PortalException {
		
		// TODO: Add permission checking
		
		return submissionLocalService.gradeSubmission(submissionId, grade);
	}

	
	public Submission gradeAndCommentSubmission(long submissionId, int grade, String comment) throws PortalException {
		
		// TODO: Add permission checking
		
		return submissionLocalService.gradeAndCommentSubmission(submissionId, grade, comment);
	}
	
	public List<Submission> getSubmissionsByAssignment(
		long groupId, long assignmentId) {
		
		// TODO: Add permission checking

		return submissionPersistence.findByG_A(groupId, assignmentId);
	}

	public List<Submission> getSubmissionsByAssignment(
		long groupId, long assignmentId, int start, int end) {

		// TODO: Add permission checking
		
		return submissionPersistence.findByG_A(
			groupId, assignmentId, start, end);
	}

	public int getSubmissionsCountByAssignment(
		long groupId, long assignmentId) {

		// TODO: Add permission checking

		return submissionPersistence.countByG_A(groupId, assignmentId);
	}
	
	public List<Submission> getSubmissionsByKeywords(long groupId, long assignmentId, String keywords, int start, int end, OrderByComparator<Submission> orderByComparator) {
		return submissionLocalService.getSubmissionsByKeywords(groupId, assignmentId, keywords, start, end, orderByComparator);
	}


	public long getSubmissionsCountByKeywords(long groupId, long assignmentId, String keywords) {
		return submissionLocalService.getSubmissionsCountByKeywords(groupId, assignmentId, keywords);
	}

	public Submission updateSubmission(long submissionId, String submissionText, ServiceContext serviceContext) throws PortalException {
		
		// TODO: Add permission checking
		
		return submissionLocalService.updateSubmission(submissionId, submissionText, serviceContext);
	}

}