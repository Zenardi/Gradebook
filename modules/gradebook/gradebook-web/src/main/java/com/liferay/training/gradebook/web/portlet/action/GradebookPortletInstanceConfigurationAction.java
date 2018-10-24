
package com.liferay.training.gradebook.web.portlet.action;

import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.training.gradebook.web.constants.GradebookPortletKeys;

import javax.servlet.ServletContext;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * Configuration action component (configuration.jsp).
 * 
 * @author liferay
 */
@Component(
	immediate = true, 
	property = {
		"javax.portlet.name=" + GradebookPortletKeys.GRADEBOOK
	}, 
	service = ConfigurationAction.class
)
public class GradebookPortletInstanceConfigurationAction extends DefaultConfigurationAction {

	@Override
	@Reference(target = "(osgi.web.symbolicname=com.liferay.training.gradebook.web)", unbind = "-")
	public void setServletContext(ServletContext servletContext) {

		super.setServletContext(servletContext);
	}
}
