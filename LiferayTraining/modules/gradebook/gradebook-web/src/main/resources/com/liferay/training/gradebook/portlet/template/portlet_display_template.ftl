<#--

	This is an example Application Display Template for the Gradebook Application.

	Application display templates can be used to modify the look of a
	specific application.

	Please use the left panel to quickly add commonly used variables.
	Autocomplete is also available and can be invoked by typing "${".


-->

<div class="container-fluid-1280">

	<h1>This is Using a Custom Application Display Template</h1>

	<div class="flex-container">

		<@liferay_ui["search-container"] emptyResultsMessage="there-are-no-assignments-for-this-class">
			<@liferay_ui["search-container-results"] results=entries />
			<@liferay_ui["search-container-row"]
				className="com.liferay.training.gradebook.model.Assignment"
				modelVar="assignment">

				<@liferay_portlet["renderURL"] var="viewSubmissionsURL">
					<@liferay_portlet["param"] name="mvcRenderCommandName"
						value="/gradebook/submissions/view" />
					<@liferay_portlet["param"] name="redirect" value="${currentURL}" />
					<@liferay_portlet["param"] name="assignmentId"
						value="${assignment.getAssignmentId()}" />
				</@>
				
				<@liferay_frontend["icon-vertical-card"] icon="folder"
					title="${assignment.getTitle(locale)}"
					actionJsp="/assignment/entry_actions.jsp"
					cssClass="col-md-3 flex-item-break-xs card-row-padded"
					actionJspServletContext=application resultRow=row
					url="${viewSubmissionsURL}">

					<@liferay_frontend["vertical-card-footer"]>
						<p class="truncate-text flex-item-center">${assignment.getDescription()}</p>
					</@>
				</@>
			</@>

			<liferay_ui["search-iterator"] markupView="lexicon" />
		</@>
	</div>
</div>