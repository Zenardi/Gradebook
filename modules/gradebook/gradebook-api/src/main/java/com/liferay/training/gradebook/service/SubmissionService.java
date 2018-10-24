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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.liferay.training.gradebook.model.Submission;

import java.util.List;

/**
 * Provides the remote service interface for Submission. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see SubmissionServiceUtil
 * @see com.liferay.training.gradebook.service.base.SubmissionServiceBaseImpl
 * @see com.liferay.training.gradebook.service.impl.SubmissionServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@OSGiBeanProperties(property =  {
	"json.web.service.context.name=gradebook", "json.web.service.context.path=Submission"}, service = SubmissionService.class)
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface SubmissionService extends BaseService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SubmissionServiceUtil} to access the submission remote service. Add custom service methods to {@link com.liferay.training.gradebook.service.impl.SubmissionServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public Submission addSubmission(long assignmentId, long studentId,
		java.lang.String submissionText, ServiceContext serviceContext)
		throws PortalException;

	public Submission deleteSubmission(long submissionId)
		throws PortalException;

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Submission> getSubmissionsByAssignment(long groupId,
		long assignmentId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Submission> getSubmissionsByAssignment(long groupId,
		long assignmentId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Submission> getSubmissionsByKeywords(long groupId,
		long assignmentId, java.lang.String keywords, int start, int end,
		OrderByComparator<Submission> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getSubmissionsCountByAssignment(long groupId, long assignmentId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getSubmissionsCountByKeywords(long groupId, long assignmentId,
		java.lang.String keywords);

	public Submission gradeAndCommentSubmission(long submissionId, int grade,
		java.lang.String comment) throws PortalException;

	public Submission gradeSubmission(long submissionId, int grade)
		throws PortalException;

	public Submission updateSubmission(long submissionId,
		java.lang.String submissionText, ServiceContext serviceContext)
		throws PortalException;
}