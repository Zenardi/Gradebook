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

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Assignment}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Assignment
 * @generated
 */
@ProviderType
public class AssignmentWrapper implements Assignment, ModelWrapper<Assignment> {
	public AssignmentWrapper(Assignment assignment) {
		_assignment = assignment;
	}

	@Override
	public Class<?> getModelClass() {
		return Assignment.class;
	}

	@Override
	public String getModelClassName() {
		return Assignment.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("assignmentId", getAssignmentId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("dueDate", getDueDate());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long assignmentId = (Long)attributes.get("assignmentId");

		if (assignmentId != null) {
			setAssignmentId(assignmentId);
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

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Date dueDate = (Date)attributes.get("dueDate");

		if (dueDate != null) {
			setDueDate(dueDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}
	}

	@Override
	public java.lang.Object clone() {
		return new AssignmentWrapper((Assignment)_assignment.clone());
	}

	@Override
	public int compareTo(Assignment assignment) {
		return _assignment.compareTo(assignment);
	}

	/**
	* Returns the assignment ID of this assignment.
	*
	* @return the assignment ID of this assignment
	*/
	@Override
	public long getAssignmentId() {
		return _assignment.getAssignmentId();
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _assignment.getAvailableLanguageIds();
	}

	/**
	* Returns the company ID of this assignment.
	*
	* @return the company ID of this assignment
	*/
	@Override
	public long getCompanyId() {
		return _assignment.getCompanyId();
	}

	/**
	* Returns the create date of this assignment.
	*
	* @return the create date of this assignment
	*/
	@Override
	public Date getCreateDate() {
		return _assignment.getCreateDate();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _assignment.getDefaultLanguageId();
	}

	/**
	* Returns the description of this assignment.
	*
	* @return the description of this assignment
	*/
	@Override
	public java.lang.String getDescription() {
		return _assignment.getDescription();
	}

	/**
	* Returns the due date of this assignment.
	*
	* @return the due date of this assignment
	*/
	@Override
	public Date getDueDate() {
		return _assignment.getDueDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _assignment.getExpandoBridge();
	}

	/**
	* Returns the group ID of this assignment.
	*
	* @return the group ID of this assignment
	*/
	@Override
	public long getGroupId() {
		return _assignment.getGroupId();
	}

	/**
	* Returns the modified date of this assignment.
	*
	* @return the modified date of this assignment
	*/
	@Override
	public Date getModifiedDate() {
		return _assignment.getModifiedDate();
	}

	/**
	* Returns the primary key of this assignment.
	*
	* @return the primary key of this assignment
	*/
	@Override
	public long getPrimaryKey() {
		return _assignment.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _assignment.getPrimaryKeyObj();
	}

	/**
	* Returns the status of this assignment.
	*
	* @return the status of this assignment
	*/
	@Override
	public int getStatus() {
		return _assignment.getStatus();
	}

	/**
	* Returns the status by user ID of this assignment.
	*
	* @return the status by user ID of this assignment
	*/
	@Override
	public long getStatusByUserId() {
		return _assignment.getStatusByUserId();
	}

	/**
	* Returns the status by user name of this assignment.
	*
	* @return the status by user name of this assignment
	*/
	@Override
	public java.lang.String getStatusByUserName() {
		return _assignment.getStatusByUserName();
	}

	/**
	* Returns the status by user uuid of this assignment.
	*
	* @return the status by user uuid of this assignment
	*/
	@Override
	public java.lang.String getStatusByUserUuid() {
		return _assignment.getStatusByUserUuid();
	}

	/**
	* Returns the status date of this assignment.
	*
	* @return the status date of this assignment
	*/
	@Override
	public Date getStatusDate() {
		return _assignment.getStatusDate();
	}

	/**
	* Returns the title of this assignment.
	*
	* @return the title of this assignment
	*/
	@Override
	public java.lang.String getTitle() {
		return _assignment.getTitle();
	}

	/**
	* Returns the localized title of this assignment in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized title of this assignment
	*/
	@Override
	public java.lang.String getTitle(java.util.Locale locale) {
		return _assignment.getTitle(locale);
	}

	/**
	* Returns the localized title of this assignment in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized title of this assignment. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getTitle(java.util.Locale locale, boolean useDefault) {
		return _assignment.getTitle(locale, useDefault);
	}

	/**
	* Returns the localized title of this assignment in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized title of this assignment
	*/
	@Override
	public java.lang.String getTitle(java.lang.String languageId) {
		return _assignment.getTitle(languageId);
	}

	/**
	* Returns the localized title of this assignment in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized title of this assignment
	*/
	@Override
	public java.lang.String getTitle(java.lang.String languageId,
		boolean useDefault) {
		return _assignment.getTitle(languageId, useDefault);
	}

	@Override
	public java.lang.String getTitleCurrentLanguageId() {
		return _assignment.getTitleCurrentLanguageId();
	}

	@Override
	public java.lang.String getTitleCurrentValue() {
		return _assignment.getTitleCurrentValue();
	}

	/**
	* Returns a map of the locales and localized titles of this assignment.
	*
	* @return the locales and localized titles of this assignment
	*/
	@Override
	public Map<java.util.Locale, java.lang.String> getTitleMap() {
		return _assignment.getTitleMap();
	}

	/**
	* Returns the user ID of this assignment.
	*
	* @return the user ID of this assignment
	*/
	@Override
	public long getUserId() {
		return _assignment.getUserId();
	}

	/**
	* Returns the user name of this assignment.
	*
	* @return the user name of this assignment
	*/
	@Override
	public java.lang.String getUserName() {
		return _assignment.getUserName();
	}

	/**
	* Returns the user uuid of this assignment.
	*
	* @return the user uuid of this assignment
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _assignment.getUserUuid();
	}

	/**
	* Returns the uuid of this assignment.
	*
	* @return the uuid of this assignment
	*/
	@Override
	public java.lang.String getUuid() {
		return _assignment.getUuid();
	}

	@Override
	public int hashCode() {
		return _assignment.hashCode();
	}

	/**
	* Returns <code>true</code> if this assignment is approved.
	*
	* @return <code>true</code> if this assignment is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproved() {
		return _assignment.isApproved();
	}

	@Override
	public boolean isCachedModel() {
		return _assignment.isCachedModel();
	}

	/**
	* Returns <code>true</code> if this assignment is denied.
	*
	* @return <code>true</code> if this assignment is denied; <code>false</code> otherwise
	*/
	@Override
	public boolean isDenied() {
		return _assignment.isDenied();
	}

	/**
	* Returns <code>true</code> if this assignment is a draft.
	*
	* @return <code>true</code> if this assignment is a draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _assignment.isDraft();
	}

	@Override
	public boolean isEscapedModel() {
		return _assignment.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this assignment is expired.
	*
	* @return <code>true</code> if this assignment is expired; <code>false</code> otherwise
	*/
	@Override
	public boolean isExpired() {
		return _assignment.isExpired();
	}

	/**
	* Returns <code>true</code> if this assignment is inactive.
	*
	* @return <code>true</code> if this assignment is inactive; <code>false</code> otherwise
	*/
	@Override
	public boolean isInactive() {
		return _assignment.isInactive();
	}

	/**
	* Returns <code>true</code> if this assignment is incomplete.
	*
	* @return <code>true</code> if this assignment is incomplete; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncomplete() {
		return _assignment.isIncomplete();
	}

	@Override
	public boolean isNew() {
		return _assignment.isNew();
	}

	/**
	* Returns <code>true</code> if this assignment is pending.
	*
	* @return <code>true</code> if this assignment is pending; <code>false</code> otherwise
	*/
	@Override
	public boolean isPending() {
		return _assignment.isPending();
	}

	/**
	* Returns <code>true</code> if this assignment is scheduled.
	*
	* @return <code>true</code> if this assignment is scheduled; <code>false</code> otherwise
	*/
	@Override
	public boolean isScheduled() {
		return _assignment.isScheduled();
	}

	@Override
	public void persist() {
		_assignment.persist();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.kernel.exception.LocaleException {
		_assignment.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.kernel.exception.LocaleException {
		_assignment.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	/**
	* Sets the assignment ID of this assignment.
	*
	* @param assignmentId the assignment ID of this assignment
	*/
	@Override
	public void setAssignmentId(long assignmentId) {
		_assignment.setAssignmentId(assignmentId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_assignment.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this assignment.
	*
	* @param companyId the company ID of this assignment
	*/
	@Override
	public void setCompanyId(long companyId) {
		_assignment.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this assignment.
	*
	* @param createDate the create date of this assignment
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_assignment.setCreateDate(createDate);
	}

	/**
	* Sets the description of this assignment.
	*
	* @param description the description of this assignment
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_assignment.setDescription(description);
	}

	/**
	* Sets the due date of this assignment.
	*
	* @param dueDate the due date of this assignment
	*/
	@Override
	public void setDueDate(Date dueDate) {
		_assignment.setDueDate(dueDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_assignment.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_assignment.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_assignment.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this assignment.
	*
	* @param groupId the group ID of this assignment
	*/
	@Override
	public void setGroupId(long groupId) {
		_assignment.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this assignment.
	*
	* @param modifiedDate the modified date of this assignment
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_assignment.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_assignment.setNew(n);
	}

	/**
	* Sets the primary key of this assignment.
	*
	* @param primaryKey the primary key of this assignment
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_assignment.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_assignment.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the status of this assignment.
	*
	* @param status the status of this assignment
	*/
	@Override
	public void setStatus(int status) {
		_assignment.setStatus(status);
	}

	/**
	* Sets the status by user ID of this assignment.
	*
	* @param statusByUserId the status by user ID of this assignment
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_assignment.setStatusByUserId(statusByUserId);
	}

	/**
	* Sets the status by user name of this assignment.
	*
	* @param statusByUserName the status by user name of this assignment
	*/
	@Override
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_assignment.setStatusByUserName(statusByUserName);
	}

	/**
	* Sets the status by user uuid of this assignment.
	*
	* @param statusByUserUuid the status by user uuid of this assignment
	*/
	@Override
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_assignment.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Sets the status date of this assignment.
	*
	* @param statusDate the status date of this assignment
	*/
	@Override
	public void setStatusDate(Date statusDate) {
		_assignment.setStatusDate(statusDate);
	}

	/**
	* Sets the title of this assignment.
	*
	* @param title the title of this assignment
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_assignment.setTitle(title);
	}

	/**
	* Sets the localized title of this assignment in the language.
	*
	* @param title the localized title of this assignment
	* @param locale the locale of the language
	*/
	@Override
	public void setTitle(java.lang.String title, java.util.Locale locale) {
		_assignment.setTitle(title, locale);
	}

	/**
	* Sets the localized title of this assignment in the language, and sets the default locale.
	*
	* @param title the localized title of this assignment
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setTitle(java.lang.String title, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_assignment.setTitle(title, locale, defaultLocale);
	}

	@Override
	public void setTitleCurrentLanguageId(java.lang.String languageId) {
		_assignment.setTitleCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized titles of this assignment from the map of locales and localized titles.
	*
	* @param titleMap the locales and localized titles of this assignment
	*/
	@Override
	public void setTitleMap(Map<java.util.Locale, java.lang.String> titleMap) {
		_assignment.setTitleMap(titleMap);
	}

	/**
	* Sets the localized titles of this assignment from the map of locales and localized titles, and sets the default locale.
	*
	* @param titleMap the locales and localized titles of this assignment
	* @param defaultLocale the default locale
	*/
	@Override
	public void setTitleMap(Map<java.util.Locale, java.lang.String> titleMap,
		java.util.Locale defaultLocale) {
		_assignment.setTitleMap(titleMap, defaultLocale);
	}

	/**
	* Sets the user ID of this assignment.
	*
	* @param userId the user ID of this assignment
	*/
	@Override
	public void setUserId(long userId) {
		_assignment.setUserId(userId);
	}

	/**
	* Sets the user name of this assignment.
	*
	* @param userName the user name of this assignment
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_assignment.setUserName(userName);
	}

	/**
	* Sets the user uuid of this assignment.
	*
	* @param userUuid the user uuid of this assignment
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_assignment.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this assignment.
	*
	* @param uuid the uuid of this assignment
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_assignment.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Assignment> toCacheModel() {
		return _assignment.toCacheModel();
	}

	@Override
	public Assignment toEscapedModel() {
		return new AssignmentWrapper(_assignment.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _assignment.toString();
	}

	@Override
	public Assignment toUnescapedModel() {
		return new AssignmentWrapper(_assignment.toUnescapedModel());
	}

	@Override
	public java.lang.String toXmlString() {
		return _assignment.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AssignmentWrapper)) {
			return false;
		}

		AssignmentWrapper assignmentWrapper = (AssignmentWrapper)obj;

		if (Objects.equals(_assignment, assignmentWrapper._assignment)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _assignment.getStagedModelType();
	}

	@Override
	public Assignment getWrappedModel() {
		return _assignment;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _assignment.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _assignment.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_assignment.resetOriginalValues();
	}

	private final Assignment _assignment;
}