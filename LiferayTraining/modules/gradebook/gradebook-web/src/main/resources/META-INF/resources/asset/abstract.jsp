<%-- 
	This is for showing assignment abstract in Asset Publisher portlet.  
--%>

<%@ include file="/init.jsp"%>

<p>
	<%
		AssetRenderer<?> assetRenderer = (AssetRenderer<?>)request.getAttribute(WebKeys.ASSET_RENDERER);
	%>

	<%= HtmlUtil.escape(assetRenderer.getSummary(renderRequest, renderResponse)) %>
</p>
