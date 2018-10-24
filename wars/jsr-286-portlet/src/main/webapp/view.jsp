<%@ include file="/init.jsp" %>

<p class="caption">
	<liferay-ui:message key="jsr-286-portlet.caption" />
</p>

<%
String cssStyle = "";

String bgColor = request.getParameter("backgroundColor");

if(bgColor != null && !bgColor.isEmpty()){
	cssStyle = "background-color: " + bgColor + ";";
}
%>

<portlet:renderURL var="viewRedURL">
	<portlet:param name="backgroundColor" value="red"/>
</portlet:renderURL>


<portlet:renderURL var="viewYellowURL">
	<portlet:param name="backgroundColor" value="yellow"/>
</portlet:renderURL>

<div class="btn-group">
	<a class="btn btn-default" href="<%= viewRedURL %>">Set Red</a>
	<a class="btn btn-default" href="<%= viewYellowURL %>">Set Yellow</a>
</div>

