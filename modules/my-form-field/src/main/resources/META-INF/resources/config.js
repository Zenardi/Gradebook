;(function() {
	AUI().applyConfig(
		{
			groups: {
				'field-my-form-field': {
					base: MODULE_PATH + '/',
					combine: Liferay.AUI.getCombine(),
					filter: Liferay.AUI.getFilterConfig(),
					modules: {
						'my-form-field-form-field': {
							condition: {
								trigger: 'liferay-ddm-form-renderer'
							},
							path: 'my-form-field_field.js',
							requires: [
								'liferay-ddm-form-renderer-field'
							]
						}
					},
					root: MODULE_PATH + '/'
				}
			}
		}
	);
})();