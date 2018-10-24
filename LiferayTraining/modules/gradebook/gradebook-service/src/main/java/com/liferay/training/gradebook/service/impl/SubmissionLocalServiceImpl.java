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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.spring.extender.service.ServiceReference;
import com.liferay.training.gradebook.configuration.GradebookSystemServiceConfiguration;
//import com.liferay.training.gradebook.configuration.GradebookSystemServiceConfiguration;
import com.liferay.training.gradebook.exception.SubmissionValidationException;
import com.liferay.training.gradebook.model.Assignment;
import com.liferay.training.gradebook.model.Submission;
import com.liferay.training.gradebook.service.base.SubmissionLocalServiceBaseImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The implementation of the submission local service. <p> All custom service
 * methods should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the
 * {@link com.liferay.training.gradebook.service.SubmissionLocalService}
 * interface. <p> This is a local service. Methods of this service will not have
 * security checks based on the propagated JAAS credentials because this service
 * can only be accessed from within the same VM. </p>
 *
 * @author Brian Wing Shun Chan
 * @see SubmissionLocalServiceBaseImpl
 * @see com.liferay.training.gradebook.service.SubmissionLocalServiceUtil
 */
public class SubmissionLocalServiceImpl extends SubmissionLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS: Never reference this class directly. Always use
	 * {@link com.liferay.training.gradebook.service.SubmissionLocalServiceUtil}
	 * to access the submission local service.
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
	@Override
	public Submission addSubmission(
		long assignmentId, long studentId, String submissionText,
		ServiceContext serviceContext)
		throws PortalException {

		Assignment assignment =
			assignmentLocalService.getAssignment(assignmentId);

		long userId = serviceContext.getUserId();

		// Verify that user exists.

		User user = userLocalService.getUser(userId);

		// Verify that student exists.

		User studentUser = userLocalService.getUser(studentId);

		// Validate submission

		validateSubmission(serviceContext.getCompanyId(), studentId, assignment, submissionText);

		// Create submission id.
		
		long submissionId =
			counterLocalService.increment(Submission.class.getName());

		// Create new submission.
		
		Submission submission =
			submissionLocalService.createSubmission(submissionId);

		submission.setSubmissionId(submissionId);
		submission.setAssignmentId(assignmentId);
		submission.setCompanyId(assignment.getCompanyId());
		submission.setGroupId(assignment.getGroupId());
		submission.setCreateDate(new Date());
		submission.setModifiedDate(new Date());

		submission.setUserId(userId);
		submission.setGrade(-1);
		submission.setStudentId(studentId);
		submission.setSubmissionText(submissionText);
		submission.setSubmitDate(new Date());

		return super.addSubmission(submission);
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
	@Override
	public Submission updateSubmission(
		long submissionId, String submissionText, ServiceContext serviceContext)
		throws PortalException {

		Submission submission = getSubmission(submissionId);

		Assignment assignment =
						assignmentLocalService.getAssignment(submission.getAssignmentId());
		
		// Validate submission

		validateSubmission(serviceContext.getCompanyId(), submission.getStudentId(), assignment, submissionText);

		submission.setSubmissionText(submissionText);
		submission.setSubmitDate(new Date());

		return super.updateSubmission(submission);
	}

	public List<Submission> getSubmissionsByAssignment(
		long groupId, long assignmentId) {

		return submissionPersistence.findByG_A(groupId, assignmentId);
	}

	public List<Submission> getSubmissionsByAssignment(
		long groupId, long assignmentId, int start, int end) {

		return submissionPersistence.findByG_A(
			groupId, assignmentId, start, end);
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
	public List<Submission> getSubmissionsByKeywords(
		long groupId, long assignmentId, String keywords, int start, int end,
		OrderByComparator<Submission> orderByComparator) {

		DynamicQuery submissionsQuery = dynamicQuery().add(
			RestrictionsFactoryUtil.eq("groupId", groupId)).add(
				RestrictionsFactoryUtil.eq("assignmentId", assignmentId)).add(
					RestrictionsFactoryUtil.like(
						"submissionText", "%" + keywords + "%"));

		return dynamicQuery(submissionsQuery, start, end, orderByComparator);
	}

	public int getSubmissionsCountByAssignment(
		long groupId, long assignmentId) {

		return submissionPersistence.countByG_A(groupId, assignmentId);
	}

	public long getSubmissionsCountByKeywords(
		long groupId, long assignmentId, String keywords) {

		DynamicQuery submissionsQuery = dynamicQuery().add(
			RestrictionsFactoryUtil.eq("groupId", groupId)).add(
				RestrictionsFactoryUtil.eq("assignmentId", assignmentId)).add(
					RestrictionsFactoryUtil.like(
						"submissionText", "%" + keywords + "%"));

		return dynamicQueryCount(submissionsQuery);
	}

	/**
	 * Grades submission.
	 * 
	 * @param submissionId
	 * @param grade
	 * @return
	 * @throws PortalException
	 */
	public Submission gradeSubmission(long submissionId, int grade)
		throws PortalException {

		Submission submission = getSubmission(submissionId);

		submission.setGrade(grade);
		submission.setModifiedDate(new Date());

		return super.updateSubmission(submission);
	}

	
	public Submission gradeAndCommentSubmission(
		long submissionId, int grade, String comment)
		throws PortalException {

		Submission submission = getSubmission(submissionId);

		submission.setGrade(grade);
		submission.setComment(comment);

		submission.setModifiedDate(new Date());

		return super.updateSubmission(submission);
	}

	/**
	 * Validates submission.
	 * 
	 * @param companyId
	 * @param userId
	 * @param assignment
	 * @param submissionText
	 * @throws SubmissionValidationException
	 * @throws ConfigurationException
	 */
	private void validateSubmission(long companyId, long studentId, Assignment assignment, String submissionText)
		throws SubmissionValidationException, ConfigurationException {

		List<String> errorMessages = new ArrayList<String>();

		Date now = new Date();

		// Validate the due date.
		
		if (assignment.getDueDate().getTime() < now.getTime()) {
			errorMessages.add("error.submission-is-too-late");
		}
		
		GradebookSystemServiceConfiguration _configuration =
				_configurationProvider.getSystemConfiguration(
						GradebookSystemServiceConfiguration.class);

		// Validate submission count.
		
		long submissionCount = submissionPersistence.countByStudentIdAssignmentId(
			studentId, assignment.getAssignmentId());
		
		if (submissionCount > 0 && !_configuration.allowMultipleUserSubmissions()) {
			errorMessages.add("error.only-one-submission-allowed");
		}

		// Validate text length.
		
		if (submissionText == null) {

			errorMessages.add("error.submission-text-null");

		} else {
		
			// Strip HTML tags from text.
			
			submissionText = HtmlUtil.stripHtml(submissionText);
			
			if (submissionText.length() < _configuration.submissionMinLength()) {
				errorMessages.add("error.submission-text-too-short");
			}
			else if (submissionText.length() > _configuration.submissionMaxLength()) {
				errorMessages.add("error.submission-text-too-long");
			}
		}
			
		// Throw an exception if necessary.
		
		if (errorMessages.size() > 0) {
			throw new SubmissionValidationException(errorMessages);
		}
	}
	
	@ServiceReference(
		type = ConfigurationProvider.class
	)
	protected ConfigurationProvider _configurationProvider;
}
