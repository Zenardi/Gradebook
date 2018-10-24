<%--
	Single submission view.
--%>

<%@ include file="/init.jsp"%>

<%--Success messages. --%>

<liferay-ui:success key="submission-graded" message="submission-graded-succesfully" />

<div class="container-fluid-1280">

	<h1><liferay-ui:message key="submission-information" /></h1>

	<div class="submission-metadata">

		<dl>
			<dt><liferay-ui:message key="created" /></dt>
			<dd>${createDate}</dd>
	
			<dt><liferay-ui:message key="created-by" /></dt>
			<dd>${student}</dd>

			<dt><liferay-ui:message key="grade" /></dt>
			<dd>	
				<c:choose>
					<c:when test="${submission.grade lt 0}">
						<i><liferay-ui:message key="not-graded" /></i>
					</c:when>
				
					<c:otherwise>
						<fmt:formatNumber value="${submission.grade}" type="number" />
					</c:otherwise>
				</c:choose>
			</dd>	
			<dt><liferay-ui:message key="submission-comment" /></dt>
			<dd>
				<c:choose>
					<c:when test="${empty submission.comment}">
						<i><liferay-ui:message key="no-comment" /></i>
					</c:when>
					<c:otherwise>
						${submission.comment}
					</c:otherwise>
				</c:choose>
			</dd>	
		</dl>
	</div>

	<h2><liferay-ui:message key="submission-text" /></h2>
	
	<div class="submission-text">
		${submission.submissionText}
	</div>
	
	<aui:button-row>

		<%-- Show edit button if permissions allow and submissions is not graded. --%>
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

			<aui:button cssClass="btn btn-primary" onClick="${editSubmissionURL}" value="edit" />

		</c:if>

		<%--Show grading button. --%>

		<c:if
			test="${assignmentPermissionChecker.contains(
				permissionChecker, scopeGroupId, assignmentId, 'GRADE_SUBMISSION' )}">

			<portlet:renderURL var="gradeSubmissionURL">
				<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.GRADE_SUBMISSION %>" />
				<portlet:param name="redirect" value="${currentURL}" />
				<portlet:param name="submissionId" value="${submission.submissionId}" />
			</portlet:renderURL>
	
			<aui:button cssClass="btn btn-primary" onClick="${gradeSubmissionURL}" value="grade" />
		</c:if>
	
		<aui:button cssClass="btn btn-secondary" onClick="${param.redirect}" type="cancel"  />
	</aui:button-row>
</div>
