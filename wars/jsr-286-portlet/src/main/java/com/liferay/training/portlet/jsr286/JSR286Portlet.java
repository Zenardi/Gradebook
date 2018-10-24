package com.liferay.training.portlet.jsr286;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class JSR286Portlet implements Portlet {

	@Override
	public void init(PortletConfig config) throws PortletException {
		System.out.println("JSR286Portlet.init()");

	}

	@Override
	public void processAction(ActionRequest request, ActionResponse response) throws PortletException, IOException {
		System.out.println("JSR286Portlet.processAction()");

	}

	@Override
	public void render(RenderRequest request, RenderResponse renderResponse) throws PortletException, IOException {
		System.out.println("JSR286Portlet.render()");
		
		//PrintWriter printWriter = renderResponse.getWriter();
		//printWriter.write("Output from the JSR286Portlets render method.");
		
		String path = "/view.jsp";
		PortletSession portletSession = request.getPortletSession();
		PortletContext portletContext = portletSession.getPortletContext();
		PortletRequestDispatcher dispactcher  = portletContext.getRequestDispatcher(path);
		
		if(dispactcher == null) {
			System.err.println(path + " is not a valid include");
		}else {
			dispactcher.include(request, renderResponse);
		}
	}

	@Override
	public void destroy() {
		System.out.println("JSR286Portlet.destro()");

	}

}
