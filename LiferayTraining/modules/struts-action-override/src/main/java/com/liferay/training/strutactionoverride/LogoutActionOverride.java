package com.liferay.training.strutactionoverride;

import com.liferay.portal.kernel.struts.BaseStrutsAction;
import com.liferay.portal.kernel.struts.StrutsAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true, 
	property = {
		"path=/portal/logout"
	}, 
	service = StrutsAction.class)
public class LogoutActionOverride extends BaseStrutsAction {

	@Override
	public String execute(
		StrutsAction originalStrutsAction, HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {

		System.out.println("Overriding the Portal Logout Action!");
		
		originalStrutsAction.execute(request, response);
		
		response.sendRedirect("https://learn.liferay.com");
		
		return null; 
	}

}
