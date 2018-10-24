<%--
	Single submission view.
--%>

<%@ include file="/init.jsp"%>

<%--Grading action url. --%>

<portlet:actionURL name="<%=MVCCommandNames.GRADE_SUBMISSION %>" var="submissionGradingURL"> 
	<portlet:param name="redirect" value="${param.redirect}" />
</portlet:actionURL>

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

	<h2><liferay-ui:message key="grading" /></h2>

		<aui:form action="${submissionGradingURL}" name="gradingForm"  onSubmit="event.preventDefault();">

			<aui:input name="assignmentId" value="${submission.assignmentId}" type="hidden" />
			<aui:input name="submissionId" value="${submission.submissionId}" type="hidden" />

			<aui:fieldset-group markupView="lexicon">
				<aui:fieldset>
					<aui:field-wrapper required="true">
						<label for="grade"><liferay-ui:message key="grade-submission" /></label>
						<aui:input name="grade" value="${submission.grade}" min="4" max="10" type="number" />
					</aui:field-wrapper>			
				</aui:fieldset>
				<aui:fieldset>
					<aui:field-wrapper required="true">
						<label for="comment"><liferay-ui:message key="submission-comment" /></label>	
						<liferay-ui:input-editor contents="${submission.comment}"
						 editorName="alloyeditor"
						 name="commentEditor" placeholder="comment"  />
						 <aui:input name="comment" type="hidden" />
					</aui:field-wrapper>
				</aui:fieldset>
				
			</aui:fieldset-group>
				<aui:button cssClass="btn btn-primary" type="submit" />
				<aui:button cssClass="btn btn-secondary" onClick="${param.redirect}" type="cancel"  />
		</aui:form>	

	<aui:script>
	
		/**
		* Handle form submit. Set editor value to the hidden field 
		* which transports the value to the backend.
		*/
		AUI().ready(function() {
			
			$('#<portlet:namespace />gradingForm').on('submit', function() {
	
				var editorValue = window['<portlet:namespace />commentEditor'].getHTML();
									
				window['<portlet:namespace />comment'].value = editorValue;
	
				submitForm(document.<portlet:namespace />gradingForm);
			});
		});
	
	</aui:script>
</div>
