package my.form.field.form.field;

import com.liferay.dynamic.data.mapping.form.field.type.BaseDDMFormFieldRenderer;
import com.liferay.dynamic.data.mapping.form.field.type.DDMFormFieldRenderer;
import com.liferay.portal.kernel.template.TemplateConstants;
import com.liferay.portal.kernel.template.TemplateResource;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

/**
 * @author ZEE8CA
 */
@Component(
	immediate = true,
	property = "ddm.form.field.type.name=my-form-field",
	service = DDMFormFieldRenderer.class
)
public class MyFormFieldDDMFormFieldRenderer extends BaseDDMFormFieldRenderer {

	@Override
	public String getTemplateLanguage() {
		return TemplateConstants.LANG_TYPE_SOY;
	}

	@Override
	public String getTemplateNamespace() {
		return "DDMMyFormField.render";
	}

	@Override
	public TemplateResource getTemplateResource() {
		return _templateResource;
	}

	@Activate
	protected void activate(Map<String, Object> properties) {
		_templateResource = getTemplateResource(
			"/META-INF/resources/my-form-field.soy");
	}

	private TemplateResource _templateResource;

}