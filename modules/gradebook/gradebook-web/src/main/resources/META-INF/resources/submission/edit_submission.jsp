<%-- 
	Submission editing view.
--%>

<%@ include file="/init.jsp"%>

<%-- Generate cancel URL. --%>

<portlet:renderURL portletMode="view" var="assignmentsURL" />

<portlet:renderURL var="cancelURL">
	<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.VIEW_SUBMISSIONS %>" />
	<portlet:param name="redirect" value="${assignmentsURL}" />
	<portlet:param name="assignmentId" value="${assignment.getAssignmentId()}" />
</portlet:renderURL>

<%-- Generate add / edit action URL. --%>

<c:choose>

	<c:when test="${not empty submission}">

		<portlet:actionURL var="submissionActionURL" name="<%=MVCCommandNames.EDIT_SUBMISSION %>">
			<portlet:param name="redirect" value="${param.redirect}" />
		</portlet:actionURL>
		
		<c:set var="editTitle" value="edit-submission-for-x"/>
		
	</c:when>

	<c:otherwise>

		<portlet:actionURL var="submissionActionURL" name="<%=MVCCommandNames.ADD_SUBMISSION %>">
			<portlet:param name="redirect" value="${param.redirect}" />
		</portlet:actionURL>

		<c:set var="editTitle" value="add-submission-for-x"/>
		
	</c:otherwise>
</c:choose>

<%-- Error messages. --%>

<liferay-ui:error key="error.submission-is-too-late" message="error.submission-is-too-late" />
<liferay-ui:error key="error.only-one-submission-allowed" message="error.only-one-submission-allowed" />
<liferay-ui:error key="error.submission-service-error" message="error.submission-service-error" />
<liferay-ui:error key="error.submission-text-null" message="error.submission-text-null" />
<liferay-ui:error key="error.submission-text-too-short" message="error.submission-text-too-short" />
<liferay-ui:error key="error.submission-text-too-long" message="error.submission-text-too-long" />

<div class="container-fluid-1280">

	<h1><liferay-ui:message key="${editTitle}" arguments="${assignment.getTitle(locale)}"/></h1>
	
	<%--Show editing control based on user's permissions. --%>

	<c:if
		test="${assignmentPermissionChecker.contains(permissionChecker, scopeGroupId, assignment.assignmentId, 'EDIT_SUBMISSION' ) or (empty submission) or ( submission.studentId == user.userId) }">
		<aui:model-context bean="${submission}" model="${submissionClass}" />

		<aui:form action="${submissionActionURL}" name="fm"
			onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "saveSubmission();" %>'>

			<aui:input 
				name="assignmentId" 
				type="hidden" 
				value="${assignment.assignmentId}"				
			/>
			<aui:input name="submissionId" field="submissionId" type="hidden" />

			<aui:fieldset-group markupView="lexicon">
			
				<aui:fieldset>

					<aui:field-wrapper required="true">
						<label for="submissionText">
							<liferay-ui:message key="your-submission" />
						</label>
						<liferay-ui:input-editor 
							contents="${submission.submissionText}"
							editorName='alloyeditor' 
							name="submissionTextEditor"
							placeholder="submission-text" />
						<aui:input name="submissionText" type="hidden" />
					</aui:field-wrapper>
				</aui:fieldset>
			</aui:fieldset-group>
			
			<%--Buttons. --%>
			
			<aui:button-row>
				<aui:button cssClass="btn btn-primary" type="submit" />
				<aui:button cssClass="btn btn-secondary" onClick="<%=cancelURL %>" type="cancel" />
			</aui:button-row>
		</aui:form>

		<aui:script>
		
			/**
			* Set editor value to the hidden field which transports the value to the backend.
			*/
			function <portlet:namespace />saveSubmission() {
				
				var editorValue = window['<portlet:namespace />submissionTextEditor'].getHTML();
				
				window['<portlet:namespace />submissionText'].value = editorValue;
	
				submitForm(document.<portlet:namespace />fm);
			}

		</aui:script>
	</c:if>
</div>

