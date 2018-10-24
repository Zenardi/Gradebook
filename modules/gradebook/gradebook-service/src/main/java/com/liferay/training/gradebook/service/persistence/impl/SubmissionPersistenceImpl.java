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

package com.liferay.training.gradebook.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.liferay.training.gradebook.exception.NoSuchSubmissionException;
import com.liferay.training.gradebook.model.Submission;
import com.liferay.training.gradebook.model.impl.SubmissionImpl;
import com.liferay.training.gradebook.model.impl.SubmissionModelImpl;
import com.liferay.training.gradebook.service.persistence.SubmissionPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the submission service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SubmissionPersistence
 * @see com.liferay.training.gradebook.service.persistence.SubmissionUtil
 * @generated
 */
@ProviderType
public class SubmissionPersistenceImpl extends BasePersistenceImpl<Submission>
	implements SubmissionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SubmissionUtil} to access the submission persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SubmissionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionModelImpl.FINDER_CACHE_ENABLED, SubmissionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionModelImpl.FINDER_CACHE_ENABLED, SubmissionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionModelImpl.FINDER_CACHE_ENABLED, SubmissionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionModelImpl.FINDER_CACHE_ENABLED, SubmissionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			SubmissionModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the submissions where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching submissions
	 */
	@Override
	public List<Submission> findByGroupId(long groupId) {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Submission> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
	}

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
	@Override
	public List<Submission> findByGroupId(long groupId, int start, int end,
		OrderByComparator<Submission> orderByComparator) {
		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<Submission> findByGroupId(long groupId, int start, int end,
		OrderByComparator<Submission> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<Submission> list = null;

		if (retrieveFromCache) {
			list = (List<Submission>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Submission submission : list) {
					if ((groupId != submission.getGroupId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SUBMISSION_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SubmissionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Submission>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Submission>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first submission in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching submission
	 * @throws NoSuchSubmissionException if a matching submission could not be found
	 */
	@Override
	public Submission findByGroupId_First(long groupId,
		OrderByComparator<Submission> orderByComparator)
		throws NoSuchSubmissionException {
		Submission submission = fetchByGroupId_First(groupId, orderByComparator);

		if (submission != null) {
			return submission;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchSubmissionException(msg.toString());
	}

	/**
	 * Returns the first submission in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching submission, or <code>null</code> if a matching submission could not be found
	 */
	@Override
	public Submission fetchByGroupId_First(long groupId,
		OrderByComparator<Submission> orderByComparator) {
		List<Submission> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last submission in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching submission
	 * @throws NoSuchSubmissionException if a matching submission could not be found
	 */
	@Override
	public Submission findByGroupId_Last(long groupId,
		OrderByComparator<Submission> orderByComparator)
		throws NoSuchSubmissionException {
		Submission submission = fetchByGroupId_Last(groupId, orderByComparator);

		if (submission != null) {
			return submission;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchSubmissionException(msg.toString());
	}

	/**
	 * Returns the last submission in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching submission, or <code>null</code> if a matching submission could not be found
	 */
	@Override
	public Submission fetchByGroupId_Last(long groupId,
		OrderByComparator<Submission> orderByComparator) {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Submission> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the submissions before and after the current submission in the ordered set where groupId = &#63;.
	 *
	 * @param submissionId the primary key of the current submission
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next submission
	 * @throws NoSuchSubmissionException if a submission with the primary key could not be found
	 */
	@Override
	public Submission[] findByGroupId_PrevAndNext(long submissionId,
		long groupId, OrderByComparator<Submission> orderByComparator)
		throws NoSuchSubmissionException {
		Submission submission = findByPrimaryKey(submissionId);

		Session session = null;

		try {
			session = openSession();

			Submission[] array = new SubmissionImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, submission, groupId,
					orderByComparator, true);

			array[1] = submission;

			array[2] = getByGroupId_PrevAndNext(session, submission, groupId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Submission getByGroupId_PrevAndNext(Session session,
		Submission submission, long groupId,
		OrderByComparator<Submission> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SUBMISSION_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(SubmissionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(submission);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Submission> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the submissions where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (Submission submission : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(submission);
		}
	}

	/**
	 * Returns the number of submissions where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching submissions
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SUBMISSION_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "submission.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_A = new FinderPath(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionModelImpl.FINDER_CACHE_ENABLED, SubmissionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_A",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_A = new FinderPath(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionModelImpl.FINDER_CACHE_ENABLED, SubmissionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_A",
			new String[] { Long.class.getName(), Long.class.getName() },
			SubmissionModelImpl.GROUPID_COLUMN_BITMASK |
			SubmissionModelImpl.ASSIGNMENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_A = new FinderPath(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_A",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the submissions where groupId = &#63; and assignmentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param assignmentId the assignment ID
	 * @return the matching submissions
	 */
	@Override
	public List<Submission> findByG_A(long groupId, long assignmentId) {
		return findByG_A(groupId, assignmentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Submission> findByG_A(long groupId, long assignmentId,
		int start, int end) {
		return findByG_A(groupId, assignmentId, start, end, null);
	}

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
	@Override
	public List<Submission> findByG_A(long groupId, long assignmentId,
		int start, int end, OrderByComparator<Submission> orderByComparator) {
		return findByG_A(groupId, assignmentId, start, end, orderByComparator,
			true);
	}

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
	@Override
	public List<Submission> findByG_A(long groupId, long assignmentId,
		int start, int end, OrderByComparator<Submission> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_A;
			finderArgs = new Object[] { groupId, assignmentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_A;
			finderArgs = new Object[] {
					groupId, assignmentId,
					
					start, end, orderByComparator
				};
		}

		List<Submission> list = null;

		if (retrieveFromCache) {
			list = (List<Submission>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Submission submission : list) {
					if ((groupId != submission.getGroupId()) ||
							(assignmentId != submission.getAssignmentId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_SUBMISSION_WHERE);

			query.append(_FINDER_COLUMN_G_A_GROUPID_2);

			query.append(_FINDER_COLUMN_G_A_ASSIGNMENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SubmissionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(assignmentId);

				if (!pagination) {
					list = (List<Submission>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Submission>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first submission in the ordered set where groupId = &#63; and assignmentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param assignmentId the assignment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching submission
	 * @throws NoSuchSubmissionException if a matching submission could not be found
	 */
	@Override
	public Submission findByG_A_First(long groupId, long assignmentId,
		OrderByComparator<Submission> orderByComparator)
		throws NoSuchSubmissionException {
		Submission submission = fetchByG_A_First(groupId, assignmentId,
				orderByComparator);

		if (submission != null) {
			return submission;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", assignmentId=");
		msg.append(assignmentId);

		msg.append("}");

		throw new NoSuchSubmissionException(msg.toString());
	}

	/**
	 * Returns the first submission in the ordered set where groupId = &#63; and assignmentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param assignmentId the assignment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching submission, or <code>null</code> if a matching submission could not be found
	 */
	@Override
	public Submission fetchByG_A_First(long groupId, long assignmentId,
		OrderByComparator<Submission> orderByComparator) {
		List<Submission> list = findByG_A(groupId, assignmentId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last submission in the ordered set where groupId = &#63; and assignmentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param assignmentId the assignment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching submission
	 * @throws NoSuchSubmissionException if a matching submission could not be found
	 */
	@Override
	public Submission findByG_A_Last(long groupId, long assignmentId,
		OrderByComparator<Submission> orderByComparator)
		throws NoSuchSubmissionException {
		Submission submission = fetchByG_A_Last(groupId, assignmentId,
				orderByComparator);

		if (submission != null) {
			return submission;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", assignmentId=");
		msg.append(assignmentId);

		msg.append("}");

		throw new NoSuchSubmissionException(msg.toString());
	}

	/**
	 * Returns the last submission in the ordered set where groupId = &#63; and assignmentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param assignmentId the assignment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching submission, or <code>null</code> if a matching submission could not be found
	 */
	@Override
	public Submission fetchByG_A_Last(long groupId, long assignmentId,
		OrderByComparator<Submission> orderByComparator) {
		int count = countByG_A(groupId, assignmentId);

		if (count == 0) {
			return null;
		}

		List<Submission> list = findByG_A(groupId, assignmentId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public Submission[] findByG_A_PrevAndNext(long submissionId, long groupId,
		long assignmentId, OrderByComparator<Submission> orderByComparator)
		throws NoSuchSubmissionException {
		Submission submission = findByPrimaryKey(submissionId);

		Session session = null;

		try {
			session = openSession();

			Submission[] array = new SubmissionImpl[3];

			array[0] = getByG_A_PrevAndNext(session, submission, groupId,
					assignmentId, orderByComparator, true);

			array[1] = submission;

			array[2] = getByG_A_PrevAndNext(session, submission, groupId,
					assignmentId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Submission getByG_A_PrevAndNext(Session session,
		Submission submission, long groupId, long assignmentId,
		OrderByComparator<Submission> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_SUBMISSION_WHERE);

		query.append(_FINDER_COLUMN_G_A_GROUPID_2);

		query.append(_FINDER_COLUMN_G_A_ASSIGNMENTID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(SubmissionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(assignmentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(submission);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Submission> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the submissions where groupId = &#63; and assignmentId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param assignmentId the assignment ID
	 */
	@Override
	public void removeByG_A(long groupId, long assignmentId) {
		for (Submission submission : findByG_A(groupId, assignmentId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(submission);
		}
	}

	/**
	 * Returns the number of submissions where groupId = &#63; and assignmentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param assignmentId the assignment ID
	 * @return the number of matching submissions
	 */
	@Override
	public int countByG_A(long groupId, long assignmentId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_A;

		Object[] finderArgs = new Object[] { groupId, assignmentId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SUBMISSION_WHERE);

			query.append(_FINDER_COLUMN_G_A_GROUPID_2);

			query.append(_FINDER_COLUMN_G_A_ASSIGNMENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(assignmentId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_G_A_GROUPID_2 = "submission.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_A_ASSIGNMENTID_2 = "submission.assignmentId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STUDENTID =
		new FinderPath(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionModelImpl.FINDER_CACHE_ENABLED, SubmissionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStudentId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STUDENTID =
		new FinderPath(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionModelImpl.FINDER_CACHE_ENABLED, SubmissionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStudentId",
			new String[] { Long.class.getName() },
			SubmissionModelImpl.STUDENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STUDENTID = new FinderPath(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStudentId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the submissions where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @return the matching submissions
	 */
	@Override
	public List<Submission> findByStudentId(long studentId) {
		return findByStudentId(studentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

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
	@Override
	public List<Submission> findByStudentId(long studentId, int start, int end) {
		return findByStudentId(studentId, start, end, null);
	}

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
	@Override
	public List<Submission> findByStudentId(long studentId, int start, int end,
		OrderByComparator<Submission> orderByComparator) {
		return findByStudentId(studentId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<Submission> findByStudentId(long studentId, int start, int end,
		OrderByComparator<Submission> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STUDENTID;
			finderArgs = new Object[] { studentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STUDENTID;
			finderArgs = new Object[] { studentId, start, end, orderByComparator };
		}

		List<Submission> list = null;

		if (retrieveFromCache) {
			list = (List<Submission>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Submission submission : list) {
					if ((studentId != submission.getStudentId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SUBMISSION_WHERE);

			query.append(_FINDER_COLUMN_STUDENTID_STUDENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SubmissionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(studentId);

				if (!pagination) {
					list = (List<Submission>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Submission>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first submission in the ordered set where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching submission
	 * @throws NoSuchSubmissionException if a matching submission could not be found
	 */
	@Override
	public Submission findByStudentId_First(long studentId,
		OrderByComparator<Submission> orderByComparator)
		throws NoSuchSubmissionException {
		Submission submission = fetchByStudentId_First(studentId,
				orderByComparator);

		if (submission != null) {
			return submission;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("studentId=");
		msg.append(studentId);

		msg.append("}");

		throw new NoSuchSubmissionException(msg.toString());
	}

	/**
	 * Returns the first submission in the ordered set where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching submission, or <code>null</code> if a matching submission could not be found
	 */
	@Override
	public Submission fetchByStudentId_First(long studentId,
		OrderByComparator<Submission> orderByComparator) {
		List<Submission> list = findByStudentId(studentId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last submission in the ordered set where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching submission
	 * @throws NoSuchSubmissionException if a matching submission could not be found
	 */
	@Override
	public Submission findByStudentId_Last(long studentId,
		OrderByComparator<Submission> orderByComparator)
		throws NoSuchSubmissionException {
		Submission submission = fetchByStudentId_Last(studentId,
				orderByComparator);

		if (submission != null) {
			return submission;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("studentId=");
		msg.append(studentId);

		msg.append("}");

		throw new NoSuchSubmissionException(msg.toString());
	}

	/**
	 * Returns the last submission in the ordered set where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching submission, or <code>null</code> if a matching submission could not be found
	 */
	@Override
	public Submission fetchByStudentId_Last(long studentId,
		OrderByComparator<Submission> orderByComparator) {
		int count = countByStudentId(studentId);

		if (count == 0) {
			return null;
		}

		List<Submission> list = findByStudentId(studentId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the submissions before and after the current submission in the ordered set where studentId = &#63;.
	 *
	 * @param submissionId the primary key of the current submission
	 * @param studentId the student ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next submission
	 * @throws NoSuchSubmissionException if a submission with the primary key could not be found
	 */
	@Override
	public Submission[] findByStudentId_PrevAndNext(long submissionId,
		long studentId, OrderByComparator<Submission> orderByComparator)
		throws NoSuchSubmissionException {
		Submission submission = findByPrimaryKey(submissionId);

		Session session = null;

		try {
			session = openSession();

			Submission[] array = new SubmissionImpl[3];

			array[0] = getByStudentId_PrevAndNext(session, submission,
					studentId, orderByComparator, true);

			array[1] = submission;

			array[2] = getByStudentId_PrevAndNext(session, submission,
					studentId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Submission getByStudentId_PrevAndNext(Session session,
		Submission submission, long studentId,
		OrderByComparator<Submission> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SUBMISSION_WHERE);

		query.append(_FINDER_COLUMN_STUDENTID_STUDENTID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(SubmissionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(studentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(submission);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Submission> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the submissions where studentId = &#63; from the database.
	 *
	 * @param studentId the student ID
	 */
	@Override
	public void removeByStudentId(long studentId) {
		for (Submission submission : findByStudentId(studentId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(submission);
		}
	}

	/**
	 * Returns the number of submissions where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @return the number of matching submissions
	 */
	@Override
	public int countByStudentId(long studentId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STUDENTID;

		Object[] finderArgs = new Object[] { studentId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SUBMISSION_WHERE);

			query.append(_FINDER_COLUMN_STUDENTID_STUDENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(studentId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_STUDENTID_STUDENTID_2 = "submission.studentId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STUDENTIDASSIGNMENTID =
		new FinderPath(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionModelImpl.FINDER_CACHE_ENABLED, SubmissionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByStudentIdAssignmentId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STUDENTIDASSIGNMENTID =
		new FinderPath(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionModelImpl.FINDER_CACHE_ENABLED, SubmissionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByStudentIdAssignmentId",
			new String[] { Long.class.getName(), Long.class.getName() },
			SubmissionModelImpl.STUDENTID_COLUMN_BITMASK |
			SubmissionModelImpl.ASSIGNMENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STUDENTIDASSIGNMENTID = new FinderPath(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByStudentIdAssignmentId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the submissions where studentId = &#63; and assignmentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @param assignmentId the assignment ID
	 * @return the matching submissions
	 */
	@Override
	public List<Submission> findByStudentIdAssignmentId(long studentId,
		long assignmentId) {
		return findByStudentIdAssignmentId(studentId, assignmentId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Submission> findByStudentIdAssignmentId(long studentId,
		long assignmentId, int start, int end) {
		return findByStudentIdAssignmentId(studentId, assignmentId, start, end,
			null);
	}

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
	@Override
	public List<Submission> findByStudentIdAssignmentId(long studentId,
		long assignmentId, int start, int end,
		OrderByComparator<Submission> orderByComparator) {
		return findByStudentIdAssignmentId(studentId, assignmentId, start, end,
			orderByComparator, true);
	}

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
	@Override
	public List<Submission> findByStudentIdAssignmentId(long studentId,
		long assignmentId, int start, int end,
		OrderByComparator<Submission> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STUDENTIDASSIGNMENTID;
			finderArgs = new Object[] { studentId, assignmentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STUDENTIDASSIGNMENTID;
			finderArgs = new Object[] {
					studentId, assignmentId,
					
					start, end, orderByComparator
				};
		}

		List<Submission> list = null;

		if (retrieveFromCache) {
			list = (List<Submission>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Submission submission : list) {
					if ((studentId != submission.getStudentId()) ||
							(assignmentId != submission.getAssignmentId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_SUBMISSION_WHERE);

			query.append(_FINDER_COLUMN_STUDENTIDASSIGNMENTID_STUDENTID_2);

			query.append(_FINDER_COLUMN_STUDENTIDASSIGNMENTID_ASSIGNMENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SubmissionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(studentId);

				qPos.add(assignmentId);

				if (!pagination) {
					list = (List<Submission>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Submission>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first submission in the ordered set where studentId = &#63; and assignmentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @param assignmentId the assignment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching submission
	 * @throws NoSuchSubmissionException if a matching submission could not be found
	 */
	@Override
	public Submission findByStudentIdAssignmentId_First(long studentId,
		long assignmentId, OrderByComparator<Submission> orderByComparator)
		throws NoSuchSubmissionException {
		Submission submission = fetchByStudentIdAssignmentId_First(studentId,
				assignmentId, orderByComparator);

		if (submission != null) {
			return submission;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("studentId=");
		msg.append(studentId);

		msg.append(", assignmentId=");
		msg.append(assignmentId);

		msg.append("}");

		throw new NoSuchSubmissionException(msg.toString());
	}

	/**
	 * Returns the first submission in the ordered set where studentId = &#63; and assignmentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @param assignmentId the assignment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching submission, or <code>null</code> if a matching submission could not be found
	 */
	@Override
	public Submission fetchByStudentIdAssignmentId_First(long studentId,
		long assignmentId, OrderByComparator<Submission> orderByComparator) {
		List<Submission> list = findByStudentIdAssignmentId(studentId,
				assignmentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last submission in the ordered set where studentId = &#63; and assignmentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @param assignmentId the assignment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching submission
	 * @throws NoSuchSubmissionException if a matching submission could not be found
	 */
	@Override
	public Submission findByStudentIdAssignmentId_Last(long studentId,
		long assignmentId, OrderByComparator<Submission> orderByComparator)
		throws NoSuchSubmissionException {
		Submission submission = fetchByStudentIdAssignmentId_Last(studentId,
				assignmentId, orderByComparator);

		if (submission != null) {
			return submission;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("studentId=");
		msg.append(studentId);

		msg.append(", assignmentId=");
		msg.append(assignmentId);

		msg.append("}");

		throw new NoSuchSubmissionException(msg.toString());
	}

	/**
	 * Returns the last submission in the ordered set where studentId = &#63; and assignmentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @param assignmentId the assignment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching submission, or <code>null</code> if a matching submission could not be found
	 */
	@Override
	public Submission fetchByStudentIdAssignmentId_Last(long studentId,
		long assignmentId, OrderByComparator<Submission> orderByComparator) {
		int count = countByStudentIdAssignmentId(studentId, assignmentId);

		if (count == 0) {
			return null;
		}

		List<Submission> list = findByStudentIdAssignmentId(studentId,
				assignmentId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public Submission[] findByStudentIdAssignmentId_PrevAndNext(
		long submissionId, long studentId, long assignmentId,
		OrderByComparator<Submission> orderByComparator)
		throws NoSuchSubmissionException {
		Submission submission = findByPrimaryKey(submissionId);

		Session session = null;

		try {
			session = openSession();

			Submission[] array = new SubmissionImpl[3];

			array[0] = getByStudentIdAssignmentId_PrevAndNext(session,
					submission, studentId, assignmentId, orderByComparator, true);

			array[1] = submission;

			array[2] = getByStudentIdAssignmentId_PrevAndNext(session,
					submission, studentId, assignmentId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Submission getByStudentIdAssignmentId_PrevAndNext(
		Session session, Submission submission, long studentId,
		long assignmentId, OrderByComparator<Submission> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_SUBMISSION_WHERE);

		query.append(_FINDER_COLUMN_STUDENTIDASSIGNMENTID_STUDENTID_2);

		query.append(_FINDER_COLUMN_STUDENTIDASSIGNMENTID_ASSIGNMENTID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(SubmissionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(studentId);

		qPos.add(assignmentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(submission);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Submission> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the submissions where studentId = &#63; and assignmentId = &#63; from the database.
	 *
	 * @param studentId the student ID
	 * @param assignmentId the assignment ID
	 */
	@Override
	public void removeByStudentIdAssignmentId(long studentId, long assignmentId) {
		for (Submission submission : findByStudentIdAssignmentId(studentId,
				assignmentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(submission);
		}
	}

	/**
	 * Returns the number of submissions where studentId = &#63; and assignmentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @param assignmentId the assignment ID
	 * @return the number of matching submissions
	 */
	@Override
	public int countByStudentIdAssignmentId(long studentId, long assignmentId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STUDENTIDASSIGNMENTID;

		Object[] finderArgs = new Object[] { studentId, assignmentId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SUBMISSION_WHERE);

			query.append(_FINDER_COLUMN_STUDENTIDASSIGNMENTID_STUDENTID_2);

			query.append(_FINDER_COLUMN_STUDENTIDASSIGNMENTID_ASSIGNMENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(studentId);

				qPos.add(assignmentId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_STUDENTIDASSIGNMENTID_STUDENTID_2 =
		"submission.studentId = ? AND ";
	private static final String _FINDER_COLUMN_STUDENTIDASSIGNMENTID_ASSIGNMENTID_2 =
		"submission.assignmentId = ?";

	public SubmissionPersistenceImpl() {
		setModelClass(Submission.class);

		try {
			Field field = BasePersistenceImpl.class.getDeclaredField(
					"_dbColumnNames");

			field.setAccessible(true);

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("comment", "comment_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the submission in the entity cache if it is enabled.
	 *
	 * @param submission the submission
	 */
	@Override
	public void cacheResult(Submission submission) {
		entityCache.putResult(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionImpl.class, submission.getPrimaryKey(), submission);

		submission.resetOriginalValues();
	}

	/**
	 * Caches the submissions in the entity cache if it is enabled.
	 *
	 * @param submissions the submissions
	 */
	@Override
	public void cacheResult(List<Submission> submissions) {
		for (Submission submission : submissions) {
			if (entityCache.getResult(
						SubmissionModelImpl.ENTITY_CACHE_ENABLED,
						SubmissionImpl.class, submission.getPrimaryKey()) == null) {
				cacheResult(submission);
			}
			else {
				submission.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all submissions.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SubmissionImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the submission.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Submission submission) {
		entityCache.removeResult(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionImpl.class, submission.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Submission> submissions) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Submission submission : submissions) {
			entityCache.removeResult(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
				SubmissionImpl.class, submission.getPrimaryKey());
		}
	}

	/**
	 * Creates a new submission with the primary key. Does not add the submission to the database.
	 *
	 * @param submissionId the primary key for the new submission
	 * @return the new submission
	 */
	@Override
	public Submission create(long submissionId) {
		Submission submission = new SubmissionImpl();

		submission.setNew(true);
		submission.setPrimaryKey(submissionId);

		submission.setCompanyId(companyProvider.getCompanyId());

		return submission;
	}

	/**
	 * Removes the submission with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param submissionId the primary key of the submission
	 * @return the submission that was removed
	 * @throws NoSuchSubmissionException if a submission with the primary key could not be found
	 */
	@Override
	public Submission remove(long submissionId)
		throws NoSuchSubmissionException {
		return remove((Serializable)submissionId);
	}

	/**
	 * Removes the submission with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the submission
	 * @return the submission that was removed
	 * @throws NoSuchSubmissionException if a submission with the primary key could not be found
	 */
	@Override
	public Submission remove(Serializable primaryKey)
		throws NoSuchSubmissionException {
		Session session = null;

		try {
			session = openSession();

			Submission submission = (Submission)session.get(SubmissionImpl.class,
					primaryKey);

			if (submission == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSubmissionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(submission);
		}
		catch (NoSuchSubmissionException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Submission removeImpl(Submission submission) {
		submission = toUnwrappedModel(submission);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(submission)) {
				submission = (Submission)session.get(SubmissionImpl.class,
						submission.getPrimaryKeyObj());
			}

			if (submission != null) {
				session.delete(submission);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (submission != null) {
			clearCache(submission);
		}

		return submission;
	}

	@Override
	public Submission updateImpl(Submission submission) {
		submission = toUnwrappedModel(submission);

		boolean isNew = submission.isNew();

		SubmissionModelImpl submissionModelImpl = (SubmissionModelImpl)submission;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (submission.getCreateDate() == null)) {
			if (serviceContext == null) {
				submission.setCreateDate(now);
			}
			else {
				submission.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!submissionModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				submission.setModifiedDate(now);
			}
			else {
				submission.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (submission.isNew()) {
				session.save(submission);

				submission.setNew(false);
			}
			else {
				submission = (Submission)session.merge(submission);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!SubmissionModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { submissionModelImpl.getGroupId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
				args);

			args = new Object[] {
					submissionModelImpl.getGroupId(),
					submissionModelImpl.getAssignmentId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_G_A, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_A,
				args);

			args = new Object[] { submissionModelImpl.getStudentId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_STUDENTID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STUDENTID,
				args);

			args = new Object[] {
					submissionModelImpl.getStudentId(),
					submissionModelImpl.getAssignmentId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_STUDENTIDASSIGNMENTID,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STUDENTIDASSIGNMENTID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((submissionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						submissionModelImpl.getOriginalGroupId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { submissionModelImpl.getGroupId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((submissionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_A.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						submissionModelImpl.getOriginalGroupId(),
						submissionModelImpl.getOriginalAssignmentId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_G_A, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_A,
					args);

				args = new Object[] {
						submissionModelImpl.getGroupId(),
						submissionModelImpl.getAssignmentId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_G_A, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_A,
					args);
			}

			if ((submissionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STUDENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						submissionModelImpl.getOriginalStudentId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STUDENTID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STUDENTID,
					args);

				args = new Object[] { submissionModelImpl.getStudentId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STUDENTID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STUDENTID,
					args);
			}

			if ((submissionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STUDENTIDASSIGNMENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						submissionModelImpl.getOriginalStudentId(),
						submissionModelImpl.getOriginalAssignmentId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STUDENTIDASSIGNMENTID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STUDENTIDASSIGNMENTID,
					args);

				args = new Object[] {
						submissionModelImpl.getStudentId(),
						submissionModelImpl.getAssignmentId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STUDENTIDASSIGNMENTID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STUDENTIDASSIGNMENTID,
					args);
			}
		}

		entityCache.putResult(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionImpl.class, submission.getPrimaryKey(), submission, false);

		submission.resetOriginalValues();

		return submission;
	}

	protected Submission toUnwrappedModel(Submission submission) {
		if (submission instanceof SubmissionImpl) {
			return submission;
		}

		SubmissionImpl submissionImpl = new SubmissionImpl();

		submissionImpl.setNew(submission.isNew());
		submissionImpl.setPrimaryKey(submission.getPrimaryKey());

		submissionImpl.setSubmissionId(submission.getSubmissionId());
		submissionImpl.setGroupId(submission.getGroupId());
		submissionImpl.setCompanyId(submission.getCompanyId());
		submissionImpl.setUserId(submission.getUserId());
		submissionImpl.setUserName(submission.getUserName());
		submissionImpl.setCreateDate(submission.getCreateDate());
		submissionImpl.setModifiedDate(submission.getModifiedDate());
		submissionImpl.setAssignmentId(submission.getAssignmentId());
		submissionImpl.setStudentId(submission.getStudentId());
		submissionImpl.setSubmitDate(submission.getSubmitDate());
		submissionImpl.setSubmissionText(submission.getSubmissionText());
		submissionImpl.setComment(submission.getComment());
		submissionImpl.setGrade(submission.getGrade());

		return submissionImpl;
	}

	/**
	 * Returns the submission with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the submission
	 * @return the submission
	 * @throws NoSuchSubmissionException if a submission with the primary key could not be found
	 */
	@Override
	public Submission findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSubmissionException {
		Submission submission = fetchByPrimaryKey(primaryKey);

		if (submission == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSubmissionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return submission;
	}

	/**
	 * Returns the submission with the primary key or throws a {@link NoSuchSubmissionException} if it could not be found.
	 *
	 * @param submissionId the primary key of the submission
	 * @return the submission
	 * @throws NoSuchSubmissionException if a submission with the primary key could not be found
	 */
	@Override
	public Submission findByPrimaryKey(long submissionId)
		throws NoSuchSubmissionException {
		return findByPrimaryKey((Serializable)submissionId);
	}

	/**
	 * Returns the submission with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the submission
	 * @return the submission, or <code>null</code> if a submission with the primary key could not be found
	 */
	@Override
	public Submission fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
				SubmissionImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Submission submission = (Submission)serializable;

		if (submission == null) {
			Session session = null;

			try {
				session = openSession();

				submission = (Submission)session.get(SubmissionImpl.class,
						primaryKey);

				if (submission != null) {
					cacheResult(submission);
				}
				else {
					entityCache.putResult(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
						SubmissionImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
					SubmissionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return submission;
	}

	/**
	 * Returns the submission with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param submissionId the primary key of the submission
	 * @return the submission, or <code>null</code> if a submission with the primary key could not be found
	 */
	@Override
	public Submission fetchByPrimaryKey(long submissionId) {
		return fetchByPrimaryKey((Serializable)submissionId);
	}

	@Override
	public Map<Serializable, Submission> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Submission> map = new HashMap<Serializable, Submission>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Submission submission = fetchByPrimaryKey(primaryKey);

			if (submission != null) {
				map.put(primaryKey, submission);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
					SubmissionImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Submission)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_SUBMISSION_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Submission submission : (List<Submission>)q.list()) {
				map.put(submission.getPrimaryKeyObj(), submission);

				cacheResult(submission);

				uncachedPrimaryKeys.remove(submission.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
					SubmissionImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the submissions.
	 *
	 * @return the submissions
	 */
	@Override
	public List<Submission> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Submission> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<Submission> findAll(int start, int end,
		OrderByComparator<Submission> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<Submission> findAll(int start, int end,
		OrderByComparator<Submission> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Submission> list = null;

		if (retrieveFromCache) {
			list = (List<Submission>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_SUBMISSION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SUBMISSION;

				if (pagination) {
					sql = sql.concat(SubmissionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Submission>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Submission>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the submissions from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Submission submission : findAll()) {
			remove(submission);
		}
	}

	/**
	 * Returns the number of submissions.
	 *
	 * @return the number of submissions
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SUBMISSION);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SubmissionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the submission persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(SubmissionImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_SUBMISSION = "SELECT submission FROM Submission submission";
	private static final String _SQL_SELECT_SUBMISSION_WHERE_PKS_IN = "SELECT submission FROM Submission submission WHERE submissionId IN (";
	private static final String _SQL_SELECT_SUBMISSION_WHERE = "SELECT submission FROM Submission submission WHERE ";
	private static final String _SQL_COUNT_SUBMISSION = "SELECT COUNT(submission) FROM Submission submission";
	private static final String _SQL_COUNT_SUBMISSION_WHERE = "SELECT COUNT(submission) FROM Submission submission WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "submission.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Submission exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Submission exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(SubmissionPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"comment"
			});
}