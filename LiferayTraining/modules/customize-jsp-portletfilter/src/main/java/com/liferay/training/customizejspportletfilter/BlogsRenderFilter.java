package com.liferay.training.customizejspportletfilter;

import com.liferay.portal.kernel.util.PortletKeys;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.filter.FilterChain;
import javax.portlet.filter.FilterConfig;
import javax.portlet.filter.PortletFilter;
import javax.portlet.filter.RenderFilter;
import javax.portlet.filter.RenderResponseWrapper;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true, 
	property = {"javax.portlet.name=" + PortletKeys.BLOGS},
	service = PortletFilter.class
)
public class BlogsRenderFilter implements RenderFilter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(
			RenderRequest request, RenderResponse response, FilterChain chain)
		throws IOException, PortletException {
 		
		RenderResponseWrapper renderResponseWrapper =
			new StringResponseWrapper(response);

		chain.doFilter(request, renderResponseWrapper);

		String text = renderResponseWrapper.toString();

		if (text != null) {
			String interestingText = "<input  class=\"field form-control\"";

			int index = text.lastIndexOf(interestingText);

			if (index >= 0) {
				String newText1 = text.substring(0, index);

				String newText2 =
					"\n<p>StringResponseWrapper captures the output of the Blogs Portlet before " +
					"it gets written to the output stream. This give us the chance to manipulate" +
					" the output before sending it down the filter chain.</p>\n";
				
				String newText3 = text.substring(index);

				String newText = newText1 + newText2 + newText3;

				response.getWriter().write(newText);
			}
		}
	}

	@Override
	public void init(FilterConfig config) throws PortletException {
	}

	private class StringResponseWrapper extends RenderResponseWrapper {

		public StringResponseWrapper(RenderResponse response) {
			super(response);

			_stringWriter = new StringWriter();
			_printWriter = new PrintWriter(_stringWriter);
		}

		public PrintWriter getWriter() throws IOException {
			return _printWriter;
		}

		public String toString() {
			return _stringWriter.toString();
		}

		private PrintWriter _printWriter;
		private StringWriter _stringWriter;
	}
}