
package com.liferay.training.gradebook.web.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.training.gradebook.web.constants.GradebookPortletKeys;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * Gradebook portlet component class.
 * 
 * @author liferay
 *
 */
@Component(
	immediate = true, 
	property = {
		"com.liferay.portlet.add-default-resource=true",
		"com.liferay.portlet.css-class-wrapper=gradebook-portlet",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.footer-portlet-javascript=/js/main.js",
        "com.liferay.portlet.display-category=category.training",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=gradebook-web-portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.name=" + GradebookPortletKeys.GRADEBOOK,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	}, 
	service = Portlet.class
)
public class GradebookPortlet extends MVCPortlet {

}
