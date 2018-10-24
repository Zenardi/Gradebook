import Component from 'metal-component';
import Soy from 'metal-soy';

import templates from './my-form-field.soy';

/**
 * MyFormField Component
 */
class MyFormField extends Component {}

// Register component
Soy.register(MyFormField, templates, 'render');

if (!window.DDMMyFormField) {
	window.DDMMyFormField = {

	};
}

window.DDMMyFormField.render = MyFormField;

export default MyFormField;