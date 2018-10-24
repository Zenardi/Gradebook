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

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.liferay.training.gradebook.model.Submission;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for Submission. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see SubmissionLocalServiceUtil
 * @see com.liferay.training.gradebook.service.base.SubmissionLocalServiceBaseImpl
 * @see com.liferay.training.gradebook.service.impl.SubmissionLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface SubmissionLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SubmissionLocalServiceUtil} to access the submission local service. Add custom service methods to {@link com.liferay.training.gradebook.service.impl.SubmissionLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
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
	public Submission addSubmission(long assignmentId, long studentId,
		java.lang.String submissionText, ServiceContext serviceContext)
		throws PortalException;

	/**
	* Adds the submission to the database. Also notifies the appropriate model listeners.
	*
	* @param submission the submission
	* @return the submission that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public Submission addSubmission(Submission submission);

	/**
	* Creates a new submission with the primary key. Does not add the submission to the database.
	*
	* @param submissionId the primary key for the new submission
	* @return the new submission
	*/
	public Submission createSubmission(long submissionId);

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	* Deletes the submission with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param submissionId the primary key of the submission
	* @return the submission that was removed
	* @throws PortalException if a submission with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public Submission deleteSubmission(long submissionId)
		throws PortalException;

	/**
	* Deletes the submission from the database. Also notifies the appropriate model listeners.
	*
	* @param submission the submission
	* @return the submission that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public Submission deleteSubmission(Submission submission);

	public DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end);

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
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Submission fetchSubmission(long submissionId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	* Returns the submission with the primary key.
	*
	* @param submissionId the primary key of the submission
	* @return the submission
	* @throws PortalException if a submission with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Submission getSubmission(long submissionId)
		throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Submission> getSubmissions(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Submission> getSubmissionsByAssignment(long groupId,
		long assignmentId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Submission> getSubmissionsByAssignment(long groupId,
		long assignmentId, int start, int end);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Submission> getSubmissionsByKeywords(long groupId,
		long assignmentId, java.lang.String keywords, int start, int end,
		OrderByComparator<Submission> orderByComparator);

	/**
	* Returns the number of submissions.
	*
	* @return the number of submissions
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getSubmissionsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getSubmissionsCountByAssignment(long groupId, long assignmentId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getSubmissionsCountByKeywords(long groupId, long assignmentId,
		java.lang.String keywords);

	public Submission gradeAndCommentSubmission(long submissionId, int grade,
		java.lang.String comment) throws PortalException;

	/**
	* Grades submission.
	*
	* @param submissionId
	* @param grade
	* @return
	* @throws PortalException
	*/
	public Submission gradeSubmission(long submissionId, int grade)
		throws PortalException;

	/**
	* Updates submission.
	*
	* @param submissionId
	* @param submissionText
	* @param serviceContext
	* @return
	* @throws PortalException
	*/
	public Submission updateSubmission(long submissionId,
		java.lang.String submissionText, ServiceContext serviceContext)
		throws PortalException;

	/**
	* Updates the submission in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param submission the submission
	* @return the submission that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public Submission updateSubmission(Submission submission);
}