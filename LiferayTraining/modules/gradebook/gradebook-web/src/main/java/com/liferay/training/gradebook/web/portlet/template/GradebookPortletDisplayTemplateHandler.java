
package com.liferay.training.gradebook.web.portlet.template;

import com.liferay.portal.kernel.portletdisplaytemplate.BasePortletDisplayTemplateHandler;
import com.liferay.portal.kernel.portletdisplaytemplate.PortletDisplayTemplateManager;
import com.liferay.portal.kernel.template.TemplateHandler;
import com.liferay.portal.kernel.template.TemplateVariableGroup;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.training.gradebook.model.Assignment;
import com.liferay.training.gradebook.web.constants.GradebookPortletKeys;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * Application Display Template handler class for the Gradebook.
 * 
 * @see <a
 *      href="https://dev.liferay.com/es/develop/tutorials/-/knowledge_base/7-0/implementing-application-display-templates">Implementing
 *      Application Display Templates tutorial on Liferay Developer Network</a>
 * @author liferay
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + GradebookPortletKeys.GRADEBOOK
	},
	service = TemplateHandler.class
)
public class GradebookPortletDisplayTemplateHandler
	extends BasePortletDisplayTemplateHandler {

	@Override
	public String getClassName() {

		return Assignment.class.getName();
	}

	@Override
	public String getName(Locale locale) {

		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
			"content.Language", locale, getClass());

		return resourceBundle.getString("application-display-template-type");
	}

	@Override
	public String getResourceName() {

		return GradebookPortletKeys.GRADEBOOK;
	}

	@Override
	public Map<String, TemplateVariableGroup> getTemplateVariableGroups(
		long classPK, String language, Locale locale)
		throws Exception {

		Map<String, TemplateVariableGroup> templateVariableGroups =
			super.getTemplateVariableGroups(classPK, language, locale);

		TemplateVariableGroup templateVariableGroup =
			templateVariableGroups.get("fields");

		templateVariableGroup.empty();

		String collectionLabel = "assignments";
		String collectionName = PortletDisplayTemplateManager.ENTRIES;
		Class<List> collectionClazz = List.class;

		String itemLabel = "assignment";
		Class<Assignment> itemClazz = Assignment.class;
		String itemName = "currentAssignment";
		String itemAccessor = "getTitle(locale)";

		templateVariableGroup.addCollectionVariable(
			collectionLabel, collectionClazz, collectionName, itemLabel,
			itemClazz, itemName, itemAccessor);

		return templateVariableGroups;
	}

	@Override
	protected String getTemplatesConfigPath() {

		return "com/liferay/training/gradebook/portlet/template/portlet-display-templates.xml";
	}

	@Reference
	private Portal _portal;
}
