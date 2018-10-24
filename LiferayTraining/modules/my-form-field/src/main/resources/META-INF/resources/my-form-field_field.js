AUI.add(
	'my-form-field-form-field',
	function(A) {
		var MyFormFieldField = A.Component.create(
			{
				ATTRS: {
					type: {
						value: 'my-form-field-form-field'
					}
				},

				EXTENDS: Liferay.DDM.Renderer.Field,

				NAME: 'my-form-field-form-field'

			}
		);

		Liferay.namespace('DDM.Field').MyFormField = MyFormFieldField;
	},
	'',
	{
		requires: ['liferay-ddm-form-renderer-field']
	}
);