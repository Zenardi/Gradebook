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

package com.liferay.training.gradebook.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Submission}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Submission
 * @generated
 */
@ProviderType
public class SubmissionWrapper implements Submission, ModelWrapper<Submission> {
	public SubmissionWrapper(Submission submission) {
		_submission = submission;
	}

	@Override
	public Class<?> getModelClass() {
		return Submission.class;
	}

	@Override
	public String getModelClassName() {
		return Submission.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("submissionId", getSubmissionId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("assignmentId", getAssignmentId());
		attributes.put("studentId", getStudentId());
		attributes.put("submitDate", getSubmitDate());
		attributes.put("submissionText", getSubmissionText());
		attributes.put("comment", getComment());
		attributes.put("grade", getGrade());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long submissionId = (Long)attributes.get("submissionId");

		if (submissionId != null) {
			setSubmissionId(submissionId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long assignmentId = (Long)attributes.get("assignmentId");

		if (assignmentId != null) {
			setAssignmentId(assignmentId);
		}

		Long studentId = (Long)attributes.get("studentId");

		if (studentId != null) {
			setStudentId(studentId);
		}

		Date submitDate = (Date)attributes.get("submitDate");

		if (submitDate != null) {
			setSubmitDate(submitDate);
		}

		String submissionText = (String)attributes.get("submissionText");

		if (submissionText != null) {
			setSubmissionText(submissionText);
		}

		String comment = (String)attributes.get("comment");

		if (comment != null) {
			setComment(comment);
		}

		Integer grade = (Integer)attributes.get("grade");

		if (grade != null) {
			setGrade(grade);
		}
	}

	@Override
	public java.lang.Object clone() {
		return new SubmissionWrapper((Submission)_submission.clone());
	}

	@Override
	public int compareTo(Submission submission) {
		return _submission.compareTo(submission);
	}

	/**
	* Returns the assignment ID of this submission.
	*
	* @return the assignment ID of this submission
	*/
	@Override
	public long getAssignmentId() {
		return _submission.getAssignmentId();
	}

	/**
	* Returns the comment of this submission.
	*
	* @return the comment of this submission
	*/
	@Override
	public java.lang.String getComment() {
		return _submission.getComment();
	}

	/**
	* Returns the company ID of this submission.
	*
	* @return the company ID of this submission
	*/
	@Override
	public long getCompanyId() {
		return _submission.getCompanyId();
	}

	/**
	* Returns the create date of this submission.
	*
	* @return the create date of this submission
	*/
	@Override
	public Date getCreateDate() {
		return _submission.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _submission.getExpandoBridge();
	}

	/**
	* Returns the grade of this submission.
	*
	* @return the grade of this submission
	*/
	@Override
	public int getGrade() {
		return _submission.getGrade();
	}

	/**
	* Returns the group ID of this submission.
	*
	* @return the group ID of this submission
	*/
	@Override
	public long getGroupId() {
		return _submission.getGroupId();
	}

	/**
	* Returns the modified date of this submission.
	*
	* @return the modified date of this submission
	*/
	@Override
	public Date getModifiedDate() {
		return _submission.getModifiedDate();
	}

	/**
	* Returns the primary key of this submission.
	*
	* @return the primary key of this submission
	*/
	@Override
	public long getPrimaryKey() {
		return _submission.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _submission.getPrimaryKeyObj();
	}

	/**
	* Returns the student ID of this submission.
	*
	* @return the student ID of this submission
	*/
	@Override
	public long getStudentId() {
		return _submission.getStudentId();
	}

	/**
	* Returns the submission ID of this submission.
	*
	* @return the submission ID of this submission
	*/
	@Override
	public long getSubmissionId() {
		return _submission.getSubmissionId();
	}

	/**
	* Returns the submission text of this submission.
	*
	* @return the submission text of this submission
	*/
	@Override
	public java.lang.String getSubmissionText() {
		return _submission.getSubmissionText();
	}

	/**
	* Returns the submit date of this submission.
	*
	* @return the submit date of this submission
	*/
	@Override
	public Date getSubmitDate() {
		return _submission.getSubmitDate();
	}

	/**
	* Returns the user ID of this submission.
	*
	* @return the user ID of this submission
	*/
	@Override
	public long getUserId() {
		return _submission.getUserId();
	}

	/**
	* Returns the user name of this submission.
	*
	* @return the user name of this submission
	*/
	@Override
	public java.lang.String getUserName() {
		return _submission.getUserName();
	}

	/**
	* Returns the user uuid of this submission.
	*
	* @return the user uuid of this submission
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _submission.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _submission.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _submission.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _submission.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _submission.isNew();
	}

	@Override
	public void persist() {
		_submission.persist();
	}

	/**
	* Sets the assignment ID of this submission.
	*
	* @param assignmentId the assignment ID of this submission
	*/
	@Override
	public void setAssignmentId(long assignmentId) {
		_submission.setAssignmentId(assignmentId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_submission.setCachedModel(cachedModel);
	}

	/**
	* Sets the comment of this submission.
	*
	* @param comment the comment of this submission
	*/
	@Override
	public void setComment(java.lang.String comment) {
		_submission.setComment(comment);
	}

	/**
	* Sets the company ID of this submission.
	*
	* @param companyId the company ID of this submission
	*/
	@Override
	public void setCompanyId(long companyId) {
		_submission.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this submission.
	*
	* @param createDate the create date of this submission
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_submission.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_submission.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_submission.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_submission.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the grade of this submission.
	*
	* @param grade the grade of this submission
	*/
	@Override
	public void setGrade(int grade) {
		_submission.setGrade(grade);
	}

	/**
	* Sets the group ID of this submission.
	*
	* @param groupId the group ID of this submission
	*/
	@Override
	public void setGroupId(long groupId) {
		_submission.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this submission.
	*
	* @param modifiedDate the modified date of this submission
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_submission.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_submission.setNew(n);
	}

	/**
	* Sets the primary key of this submission.
	*
	* @param primaryKey the primary key of this submission
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_submission.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_submission.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the student ID of this submission.
	*
	* @param studentId the student ID of this submission
	*/
	@Override
	public void setStudentId(long studentId) {
		_submission.setStudentId(studentId);
	}

	/**
	* Sets the submission ID of this submission.
	*
	* @param submissionId the submission ID of this submission
	*/
	@Override
	public void setSubmissionId(long submissionId) {
		_submission.setSubmissionId(submissionId);
	}

	/**
	* Sets the submission text of this submission.
	*
	* @param submissionText the submission text of this submission
	*/
	@Override
	public void setSubmissionText(java.lang.String submissionText) {
		_submission.setSubmissionText(submissionText);
	}

	/**
	* Sets the submit date of this submission.
	*
	* @param submitDate the submit date of this submission
	*/
	@Override
	public void setSubmitDate(Date submitDate) {
		_submission.setSubmitDate(submitDate);
	}

	/**
	* Sets the user ID of this submission.
	*
	* @param userId the user ID of this submission
	*/
	@Override
	public void setUserId(long userId) {
		_submission.setUserId(userId);
	}

	/**
	* Sets the user name of this submission.
	*
	* @param userName the user name of this submission
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_submission.setUserName(userName);
	}

	/**
	* Sets the user uuid of this submission.
	*
	* @param userUuid the user uuid of this submission
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_submission.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Submission> toCacheModel() {
		return _submission.toCacheModel();
	}

	@Override
	public Submission toEscapedModel() {
		return new SubmissionWrapper(_submission.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _submission.toString();
	}

	@Override
	public Submission toUnescapedModel() {
		return new SubmissionWrapper(_submission.toUnescapedModel());
	}

	@Override
	public java.lang.String toXmlString() {
		return _submission.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SubmissionWrapper)) {
			return false;
		}

		SubmissionWrapper submissionWrapper = (SubmissionWrapper)obj;

		if (Objects.equals(_submission, submissionWrapper._submission)) {
			return true;
		}

		return false;
	}

	@Override
	public Submission getWrappedModel() {
		return _submission;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _submission.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _submission.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_submission.resetOriginalValues();
	}

	private final Submission _submission;
}