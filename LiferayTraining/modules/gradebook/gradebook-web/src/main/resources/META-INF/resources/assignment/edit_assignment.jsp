<%-- 
	Assigment editing view.
--%>

<%@ include file="/init.jsp"%>

<%-- Generate add / edit action URL and set title. --%>

<c:choose>
	<c:when test="${not empty assignment}">
		<portlet:actionURL var="assignmentActionURL" name="<%=MVCCommandNames.EDIT_ASSIGNMENT %>">
			<portlet:param name="redirect" value="${param.redirect}" />
		</portlet:actionURL>

		<c:set var="editTitle" value="edit-assignment"/>
	</c:when>
	<c:otherwise>
		<portlet:actionURL var="assignmentActionURL" name="<%=MVCCommandNames.ADD_ASSIGNMENT %>">
			<portlet:param name="redirect" value="${param.redirect}" />
		</portlet:actionURL>

		<c:set var="editTitle" value="add-assignment"/>
	</c:otherwise>
</c:choose>

<%-- Error messages. --%>

<liferay-ui:error key="error.assignment-service-error" message="error.assignment-service-error" />
<liferay-ui:error key="error.assignment-title-empty" message="error.assignment-title-empty" />
<liferay-ui:error key="error.assignment-description-empty" message="error.assignment-description-empty" />
<liferay-ui:error key="error.assignment-date-empty" message="error.assignment-date-empty" />

<div class="container-fluid-1280 edit-assignment">

	<h1><liferay-ui:message key="${editTitle}" /></h1>

	<aui:model-context bean="${assignment}" model="${assignmentClass}" />

	<aui:form action="${assignmentActionURL}" name="fm" onSubmit="event.preventDefault();">

		<aui:input name="assignmentId" field="assignmentId" type="hidden" />
		
		<aui:fieldset-group markupView="lexicon">
		
			<aui:fieldset>
			
				<%-- Title field. --%>
				
				<aui:input name="title">
				
					<aui:validator name="required" />
					
					<%-- Custom AUI validator. --%>
					
					<aui:validator errorMessage="error.assignment-title-format" name="custom">
						function(val, fieldNode, ruleValue) {
							var wordExpression = 
								new RegExp("^[^\\[\\]\\^$<>]*$");
							
							return wordExpression.test(val);
						}
					</aui:validator>
				</aui:input>

				<%-- Description field. --%>
				
				<aui:field-wrapper 
					cssClass="entry-content form-group assignment-description" 
					label="description" 
					required="true">

					<liferay-ui:input-editor 
						contents="${assignment.description}"
						editorName='alloyeditor' 
						name="descriptionEditor"
						placeholder="description">
						
						<aui:validator name="required" />
						
					</liferay-ui:input-editor>
					<aui:input name="description" type="hidden" />
				</aui:field-wrapper>

				<%-- Due date field. --%>

				<aui:input name="dueDate">
					<aui:validator name="required" />
				</aui:input>
			</aui:fieldset>
		</aui:fieldset-group>
		
		<%--Buttons. --%>
		
		<aui:button-row>
			<aui:button cssClass="btn btn-primary" type="submit" />
			<aui:button cssClass="btn btn-secondary" onClick="${param.redirect}" type="cancel" />
		</aui:button-row>
	</aui:form>

</div>


<aui:script>

	/**
	* Handle form submit. Set editor value to the hidden field 
	* which transports the value to the backend.
	*/
	AUI().ready(function() {
		
		$('#<portlet:namespace />fm').on('submit', function() {

			var editorValue = window['<portlet:namespace />descriptionEditor'].getHTML();
			
			if (editorValue.length == 0) {
				return false;
			}
			
			window['<portlet:namespace />description'].value = editorValue;

			submitForm(document.<portlet:namespace />fm);
		});
	});

</aui:script>
