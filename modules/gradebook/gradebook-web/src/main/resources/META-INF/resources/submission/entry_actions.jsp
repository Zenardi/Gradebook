<%-- 
	This shows the actions available for a single submission.
	Availability is based on user's permissions.
 --%>

<%@ include file="/init.jsp"%>

<c:set var="submission" value="${SEARCH_CONTAINER_RESULT_ROW.object}" />

<liferay-ui:icon-menu markupView="lexicon">

	<%-- View action. Show for the owner for those having grading permissions. --%>

	<c:if
		test="${submission.studentId eq user.userId or assignmentPermissionChecker.contains(permissionChecker, scopeGroupId, assignment.assignmentId, 'GRADE_SUBMISSION' )}">
		<portlet:renderURL var="viewSubmissionURL">
			<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.VIEW_SUBMISSION %>" />
			<portlet:param name="redirect" value="${currentURL}" />
			<portlet:param name="submissionId" value="${submission.submissionId}" />
		</portlet:renderURL>

		<liferay-ui:icon message="view" url="${viewSubmissionURL}" />
	</c:if>

	<%-- Grade action. --%>

	<c:if
		test="${assignmentPermissionChecker.contains(permissionChecker, scopeGroupId, assignment.assignmentId, 'GRADE_SUBMISSION' )}">
		<portlet:renderURL var="gradeSubmissionURL">
			<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.GRADE_SUBMISSION %>" />
			<portlet:param name="redirect" value="${currentURL}" />
			<portlet:param name="submissionId" value="${submission.submissionId}" />
		</portlet:renderURL>

		<liferay-ui:icon message="grade" url="${gradeSubmissionURL}" />
	</c:if>

	<%-- Edit action. Don't allow editing graded submission. --%>

	<c:if
		test="${submission.grade lt 0 
			and (assignmentPermissionChecker.contains(
			permissionChecker, scopeGroupId, assignment.assignmentId, 'EDIT_SUBMISSION' ) 
			or submission.studentId eq user.userId)}">
			
		<portlet:renderURL var="editSubmissionURL">
			<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.EDIT_SUBMISSION %>" />
			<portlet:param name="redirect" value="${currentURL}" />
			<portlet:param name="submissionId" value="${submission.submissionId}" />
		</portlet:renderURL>

		<liferay-ui:icon message="edit" url="${editSubmissionURL}" />
	</c:if>
	
	<%-- Delete action. --%>
	
	<c:if
		test="${assignmentPermissionChecker.contains(permissionChecker, scopeGroupId, assignment.assignmentId, 'DELETE_SUBMISSION' ) or submission.studentId eq user.userId}">

		<portlet:actionURL var="deleteSubmissionURL" name="<%=MVCCommandNames.DELETE_SUBMISSION %>">
			<portlet:param name="redirect" value="${currentURL}" />
			<portlet:param name="submissionId" value="${submission.submissionId}" />
		</portlet:actionURL>

		<liferay-ui:icon-delete message="delete" url="${deleteSubmissionURL}" confirmation="are-you-sure-to-delete" />
	</c:if>

</liferay-ui:icon-menu>
