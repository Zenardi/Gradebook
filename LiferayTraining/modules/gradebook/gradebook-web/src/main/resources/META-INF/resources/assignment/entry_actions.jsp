<%-- 
	Actions menu for a single assignment.
--%>

<%@ include file="/init.jsp"%>

<c:set var="assignment" value="${SEARCH_CONTAINER_RESULT_ROW.object}" />

<liferay-ui:icon-menu markupView="lexicon">

	<%-- View action. --%>

	<c:if
		test="${assignmentPermissionChecker.contains(permissionChecker, scopeGroupId, assignment.assignmentId, 'VIEW' )}">
		<portlet:renderURL var="viewSubmissionsURL">
			<portlet:param name="mvcRenderCommandName"
				value="<%=MVCCommandNames.VIEW_SUBMISSIONS %>" />
			<portlet:param name="redirect" value="${currentURL}" />
			<portlet:param name="assignmentId" value="${assignment.assignmentId}" />
		</portlet:renderURL>

		<liferay-ui:icon message="view" url="${viewSubmissionsURL}" />
	</c:if>

	<%-- Edit action. --%>

	<c:if
		test="${assignmentPermissionChecker.contains(permissionChecker, scopeGroupId, assignment.assignmentId, 'UPDATE' )}">
		<portlet:renderURL var="editAssignmentURL">
			<portlet:param name="mvcRenderCommandName"
				value="<%=MVCCommandNames.EDIT_ASSIGNMENT %>" />
			<portlet:param name="redirect" value="${currentURL}" />
			<portlet:param name="assignmentId" value="${assignment.assignmentId}" />
		</portlet:renderURL>

		<liferay-ui:icon message="edit" url="${editAssignmentURL}" />
	</c:if>
	
	<%-- Permissions action. --%>
	
	<c:if
		test="${assignmentPermissionChecker.contains(permissionChecker, scopeGroupId, assignment.assignmentId, 'PERMISSIONS')}">

		<liferay-security:permissionsURL
			modelResource="com.liferay.training.gradebook.model.Assignment"
			modelResourceDescription="${assignment.getTitle(locale)}"
			resourcePrimKey="${assignment.assignmentId}" 
			var="permissionsURL" 
		/>

		<liferay-ui:icon message="permissions" url="${permissionsURL}" />
	</c:if>
		
	<%-- Delete action. --%>
	
	<c:if
		test="${assignmentPermissionChecker.contains(permissionChecker, scopeGroupId, assignment.assignmentId, 'DELETE')}">

		<portlet:actionURL name="<%=MVCCommandNames.DELETE_ASSIGNMENT %>" var="deleteAssignmentURL">
			<portlet:param name="redirect" value="${currentURL}" />
			<portlet:param name="assignmentId" value="${assignment.assignmentId}" />
		</portlet:actionURL>

		<liferay-ui:icon-delete url="${deleteAssignmentURL}" />
	</c:if>
</liferay-ui:icon-menu>
