
package com.liferay.training.gradebook.service.configuration.definition;

import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;
import com.liferay.training.gradebook.configuration.GradebookSystemServiceConfiguration;

import org.osgi.service.component.annotations.Component;


@Component
public class GradebookSystemServiceConfigurationBeanDeclaration
	implements ConfigurationBeanDeclaration {

	@Override
	public Class<?> getConfigurationBeanClass() {

		return GradebookSystemServiceConfiguration.class;
	}
}
