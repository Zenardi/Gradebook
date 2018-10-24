package my.form.field.form.field;

import com.liferay.dynamic.data.mapping.form.field.type.BaseDDMFormFieldType;
import com.liferay.dynamic.data.mapping.form.field.type.DDMFormFieldType;

import org.osgi.service.component.annotations.Component;

/**
 * @author ZEE8CA
 */
@Component(
	immediate = true,
	property = {
		"ddm.form.field.type.description=my-form-field-description",
		"ddm.form.field.type.display.order:Integer=10",
		"ddm.form.field.type.icon=text",
		"ddm.form.field.type.js.class.name=Liferay.DDM.Field.MyFormField",
		"ddm.form.field.type.js.module=my-form-field-form-field",
		"ddm.form.field.type.label=my-form-field-label",
		"ddm.form.field.type.name=my-form-field"
	},
	service = DDMFormFieldType.class
)
public class MyFormFieldDDMFormFieldType extends BaseDDMFormFieldType {

	@Override
	public String getName() {
		return "my-form-field";
	}

}