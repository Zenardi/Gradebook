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

package com.liferay.training.gradebook.service.http;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import com.liferay.training.gradebook.service.SubmissionServiceUtil;

/**
 * Provides the HTTP utility for the
 * {@link SubmissionServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * {@link HttpPrincipal} parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SubmissionServiceSoap
 * @see HttpPrincipal
 * @see SubmissionServiceUtil
 * @generated
 */
@ProviderType
public class SubmissionServiceHttp {
	public static com.liferay.training.gradebook.model.Submission addSubmission(
		HttpPrincipal httpPrincipal, long assignmentId, long studentId,
		java.lang.String submissionText,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(SubmissionServiceUtil.class,
					"addSubmission", _addSubmissionParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					assignmentId, studentId, submissionText, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.training.gradebook.model.Submission)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.training.gradebook.model.Submission deleteSubmission(
		HttpPrincipal httpPrincipal, long submissionId)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(SubmissionServiceUtil.class,
					"deleteSubmission", _deleteSubmissionParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					submissionId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.training.gradebook.model.Submission)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.training.gradebook.model.Submission gradeSubmission(
		HttpPrincipal httpPrincipal, long submissionId, int grade)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(SubmissionServiceUtil.class,
					"gradeSubmission", _gradeSubmissionParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					submissionId, grade);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.training.gradebook.model.Submission)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.training.gradebook.model.Submission gradeAndCommentSubmission(
		HttpPrincipal httpPrincipal, long submissionId, int grade,
		java.lang.String comment)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(SubmissionServiceUtil.class,
					"gradeAndCommentSubmission",
					_gradeAndCommentSubmissionParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					submissionId, grade, comment);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.training.gradebook.model.Submission)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<com.liferay.training.gradebook.model.Submission> getSubmissionsByAssignment(
		HttpPrincipal httpPrincipal, long groupId, long assignmentId) {
		try {
			MethodKey methodKey = new MethodKey(SubmissionServiceUtil.class,
					"getSubmissionsByAssignment",
					_getSubmissionsByAssignmentParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					assignmentId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<com.liferay.training.gradebook.model.Submission>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<com.liferay.training.gradebook.model.Submission> getSubmissionsByAssignment(
		HttpPrincipal httpPrincipal, long groupId, long assignmentId,
		int start, int end) {
		try {
			MethodKey methodKey = new MethodKey(SubmissionServiceUtil.class,
					"getSubmissionsByAssignment",
					_getSubmissionsByAssignmentParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					assignmentId, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<com.liferay.training.gradebook.model.Submission>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static int getSubmissionsCountByAssignment(
		HttpPrincipal httpPrincipal, long groupId, long assignmentId) {
		try {
			MethodKey methodKey = new MethodKey(SubmissionServiceUtil.class,
					"getSubmissionsCountByAssignment",
					_getSubmissionsCountByAssignmentParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					assignmentId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<com.liferay.training.gradebook.model.Submission> getSubmissionsByKeywords(
		HttpPrincipal httpPrincipal, long groupId, long assignmentId,
		java.lang.String keywords, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.training.gradebook.model.Submission> orderByComparator) {
		try {
			MethodKey methodKey = new MethodKey(SubmissionServiceUtil.class,
					"getSubmissionsByKeywords",
					_getSubmissionsByKeywordsParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					assignmentId, keywords, start, end, orderByComparator);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<com.liferay.training.gradebook.model.Submission>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static long getSubmissionsCountByKeywords(
		HttpPrincipal httpPrincipal, long groupId, long assignmentId,
		java.lang.String keywords) {
		try {
			MethodKey methodKey = new MethodKey(SubmissionServiceUtil.class,
					"getSubmissionsCountByKeywords",
					_getSubmissionsCountByKeywordsParameterTypes8);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					assignmentId, keywords);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return ((Long)returnObj).longValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.training.gradebook.model.Submission updateSubmission(
		HttpPrincipal httpPrincipal, long submissionId,
		java.lang.String submissionText,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(SubmissionServiceUtil.class,
					"updateSubmission", _updateSubmissionParameterTypes9);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					submissionId, submissionText, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.training.gradebook.model.Submission)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(SubmissionServiceHttp.class);
	private static final Class<?>[] _addSubmissionParameterTypes0 = new Class[] {
			long.class, long.class, java.lang.String.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _deleteSubmissionParameterTypes1 = new Class[] {
			long.class
		};
	private static final Class<?>[] _gradeSubmissionParameterTypes2 = new Class[] {
			long.class, int.class
		};
	private static final Class<?>[] _gradeAndCommentSubmissionParameterTypes3 = new Class[] {
			long.class, int.class, java.lang.String.class
		};
	private static final Class<?>[] _getSubmissionsByAssignmentParameterTypes4 = new Class[] {
			long.class, long.class
		};
	private static final Class<?>[] _getSubmissionsByAssignmentParameterTypes5 = new Class[] {
			long.class, long.class, int.class, int.class
		};
	private static final Class<?>[] _getSubmissionsCountByAssignmentParameterTypes6 =
		new Class[] { long.class, long.class };
	private static final Class<?>[] _getSubmissionsByKeywordsParameterTypes7 = new Class[] {
			long.class, long.class, java.lang.String.class, int.class, int.class,
			com.liferay.portal.kernel.util.OrderByComparator.class
		};
	private static final Class<?>[] _getSubmissionsCountByKeywordsParameterTypes8 =
		new Class[] { long.class, long.class, java.lang.String.class };
	private static final Class<?>[] _updateSubmissionParameterTypes9 = new Class[] {
			long.class, java.lang.String.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
}