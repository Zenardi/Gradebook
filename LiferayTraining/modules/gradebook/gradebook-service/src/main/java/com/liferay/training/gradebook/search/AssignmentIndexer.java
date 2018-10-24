
package com.liferay.training.gradebook.search;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.IndexWriterHelper;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.training.gradebook.model.Assignment;
import com.liferay.training.gradebook.service.AssignmentLocalService;

import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * Assignment indexer.
 * 
 * This class is responsible for indexing assignments.
 * 
 * @author liferay
 *
 */
@Component(
	immediate = true, 
	service = Indexer.class
)
public class AssignmentIndexer extends BaseIndexer<Assignment> {

	public AssignmentIndexer() {

		setDefaultSelectedFieldNames(
			Field.COMPANY_ID, Field.ENTRY_CLASS_NAME, Field.ENTRY_CLASS_PK,
			Field.UID, Field.DESCRIPTION);
		setDefaultSelectedLocalizedFieldNames(Field.TITLE);
		setFilterSearch(true);
		setPermissionAware(true);
	}

	@Override
	public String getClassName() {

		return CLASS_NAME;
	}

	@Override
	public boolean hasPermission(
		PermissionChecker permissionChecker, String entryClassName,
		long entryClassPK, String actionId)
		throws Exception {
		
		Assignment assignment =
			_assignmentLocalService.getAssignment(entryClassPK);
		return permissionChecker.hasPermission(
			assignment.getGroupId(), Assignment.class.getName(),
			assignment.getAssignmentId(), ActionKeys.VIEW);
	}
	
	@Override
	public boolean isVisible(long classPK, int status) throws Exception {
		Assignment entry = _assignmentLocalService.getAssignment(classPK);

		return isVisible(entry.getStatus(), status);
	}


	@Override
	public void postProcessContextBooleanFilter(
		BooleanFilter contextBooleanFilter, SearchContext searchContext)
		throws Exception {
		
		addStatus(contextBooleanFilter, searchContext);
	}

	@Override
	protected void doDelete(Assignment assignment)
		throws Exception {

		deleteDocument(assignment.getCompanyId(), assignment.getAssignmentId());
	}

	 @Override
	    public void postProcessSearchQuery(
	        BooleanQuery searchQuery, BooleanFilter fullQueryBooleanFilter,
	        SearchContext searchContext)
	        throws Exception {

	        addSearchLocalizedTerm(searchQuery, searchContext, Field.TITLE, false);
	        addSearchTerm(searchQuery, searchContext, Field.DESCRIPTION, false);
	    }
	
	
	@Override
	protected Document doGetDocument(Assignment assignment)
		throws Exception {

		Document document = getBaseModelDocument(CLASS_NAME, assignment);
		document.addLocalizedText(Field.TITLE, assignment.getTitleMap());
		document.addText(Field.DESCRIPTION, assignment.getDescription());

		return document;
	}

	@Override
	protected Summary doGetSummary(
		Document document, Locale locale, String snippet,
		PortletRequest portletRequest, PortletResponse portletResponse)
		throws Exception {

		String prefix = Field.SNIPPET + StringPool.UNDERLINE;
		String title = document.get(prefix + Field.TITLE, Field.TITLE);
		String content = HtmlUtil.stripHtml(
			document.get(prefix + Field.DESCRIPTION, Field.DESCRIPTION));

		Summary summary = new Summary(title, content);
		summary.setMaxContentLength(200);
		return summary;
	}

	@Override
	protected void doReindex(String className, long classPK)
		throws Exception {

		Assignment assignment = _assignmentLocalService.getAssignment(classPK);
		doReindex(assignment);
	}

	@Override
	protected void doReindex(String[] ids)
		throws Exception {

		long companyId = GetterUtil.getLong(ids[0]);
		reindexAssignments(companyId);
	}

	@Override
	protected void doReindex(Assignment assignment)
		throws Exception {

		Document document = getDocument(assignment);
		_indexWriterHelper.updateDocument(
			getSearchEngineId(), assignment.getCompanyId(), document,
			isCommitImmediately());
	}

	protected void reindexAssignments(long companyId)
		throws PortalException {

		final IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			_assignmentLocalService.getIndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setCompanyId(companyId);

		// Actionable query

		indexableActionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Assignment>() {

				@Override
				public void performAction(Assignment assignment) {

					try {
						Document document = getDocument(assignment);
						indexableActionableDynamicQuery.addDocuments(document);
					}
					catch (PortalException pe) {
						if (_log.isWarnEnabled()) {
							_log.warn(
								"Unable to index assignment " +
									assignment.getAssignmentId(),
								pe);
						}
					}
				}
			});

		indexableActionableDynamicQuery.setSearchEngineId(getSearchEngineId());
		indexableActionableDynamicQuery.performActions();
	}

	private static final Log _log =
		LogFactoryUtil.getLog(AssignmentIndexer.class);

	@Reference
	private AssignmentLocalService _assignmentLocalService;

	@Reference
	protected IndexWriterHelper _indexWriterHelper;

	private static final String CLASS_NAME = Assignment.class.getName();
}
