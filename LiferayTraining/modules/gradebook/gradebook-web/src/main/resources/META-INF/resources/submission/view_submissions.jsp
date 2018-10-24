<%--
	Submissions view.
--%>

<%@ include file="/init.jsp"%>

<liferay-ui:success key="assignment-updated" message="assignment-updated-successfully" />
<liferay-ui:success key="submission-added" message="submission-added-succesfully" />
<liferay-ui:success key="submission-deleted" message="submission-deleted-succesfully" />
<liferay-ui:success key="submission-graded" message="submission-graded-succesfully" />

<%-- Submissions list --%>

<div class="container-fluid-1280">

	<h1>${assignment.getTitle(locale)}</h1>

	<h2><liferay-ui:message key="assignment-information" /></h2>
	
	<div class="assignment-metadata">

		<dl>
			<dt><liferay-ui:message key="created" /></dt>
			<dd>${createDate}</dd>
	
			<dt><liferay-ui:message key="created-by" /></dt>
			<dd>${assignment.userName}</dd>
	
			<dt><liferay-ui:message key="assignment-duedate" /></dt>
			<dd>${dueDate}</dd>
	
			<dt><liferay-ui:message key="description" /></dt>
			<dd>${assignment.description}</dd>
		</dl>
	
		<%-- Create edit assignment URL. --%>
	
		<c:if
			test="${assignmentPermissionChecker.contains(permissionChecker, scopeGroupId, assignment.assignmentId, 'UPDATE' )}">
			<portlet:renderURL var="editAssignmentURL">
				<portlet:param name="mvcRenderCommandName" 	value="<%=MVCCommandNames.EDIT_ASSIGNMENT %>" />
				<portlet:param name="redirect" value="${currentURL}" />
				<portlet:param name="assignmentId" value="${assignment.assignmentId}" />
			</portlet:renderURL>
					
			<aui:a href="${editAssignmentURL}">(<liferay-ui:message key="edit-assignment" />)</aui:a>
		</c:if>
	</div>


	<c:choose>
	<c:when
		test="${assignmentPermissionChecker.contains(
			permissionChecker, scopeGroupId, assignment.assignmentId, 'VIEW_SUBMISSIONS')}">
		
		<h2><liferay-ui:message key="submissions" /></h2>
		
		<%--Help text --%>
		
		<p><a class="gradebook-tip" href="javascript:void(0);" title="<liferay-ui:message key="submissions-help-text" />"><liferay-ui:message key="help" /> <clay:icon symbol="question-circle" /></a></p>
				
		<%-- Clay management toolbar. --%>
		
		<clay:management-toolbar
			clearResultsURL="${submissionsManagementToolbarDisplayContext.getSearchActionURL()}"
			componentId="assignmentsManagementToolbar"
			creationMenu="${submissionsManagementToolbarDisplayContext.getCreationMenu()}"
			disabled="${assignmentCount eq 0}"
			filterDropdownItems="${submissionsManagementToolbarDisplayContext.getFilterDropdownItems()}"
			itemsTotal="${assignmentCount}"
			searchActionURL="${submissionsManagementToolbarDisplayContext.getSearchActionURL()}"
			searchContainerId="submissionEntries"
			searchFormName="searchFm"
			selectable="false"			
			showInfoButton="false"
			sortingOrder="${submissionsManagementToolbarDisplayContext.getOrderByType()}"
			sortingURL="${submissionsManagementToolbarDisplayContext.getSortingURL()}"
			viewTypeItems="${submissionsManagementToolbarDisplayContext.getViewTypes()}"
		/>
				 
		<%-- The search container. --%>
		
		<liferay-ui:search-container 
			emptyResultsMessage="submissions"
			id="submissionEntries"
			iteratorURL="${portletURL}" 
			total="${submissiontCount}">
						
			<liferay-ui:search-container-results results="${submissions}" />
	
			<liferay-ui:search-container-row
				className="com.liferay.training.gradebook.model.Submission"
				modelVar="entry">
				
				<%@ include file="/submission/entry_search_columns.jspf" %>
	
			</liferay-ui:search-container-row>
	
			<liferay-ui:search-iterator markupView="lexicon" />
	
		</liferay-ui:search-container>
	</c:when>
	<c:otherwise>
	
		<clay:alert
		    message="<%=LanguageUtil.get(request, "viewing-submissions-not-allowed") %>"
		    title="Info"
		/>	
	</c:otherwise>
	</c:choose>
</div>