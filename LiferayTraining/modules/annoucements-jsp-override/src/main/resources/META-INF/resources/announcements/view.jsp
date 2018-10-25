<%@ include file="/announcements/init.jsp" %>

<h2>This is the announcements view.jsp overridden by a Fragment Module</h2>

<%-- The following allows you to include the original JSP that was overridden --%>

<liferay-util:include
	page="/announcements/view.original.jsp"
	servletContext="<%= application %>"
/>