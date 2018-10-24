package com.liferay.training.gradebook.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(
	category = "Gradebook", 
	scope = ExtendedObjectClassDefinition.Scope.SYSTEM
)
@Meta.OCD(
	id = "com.liferay.training.gradebook.configuration.GradebookSystemServiceConfiguration",
	localization = "content/Language",
	name = "gradebook-service-configuration-name"
)
public interface GradebookSystemServiceConfiguration {

	@Meta.AD(
		deflt = "10", 
		description = "submission-min-length-description", 
		name = "submission-min-length-name", 
		required = false
	)
	public int submissionMinLength();

	@Meta.AD(
		deflt = "200", 
		description = "submission-max-length-description", 
		name = "submission-max-length-name", 
		required = false
	)
	public int submissionMaxLength();

	@Meta.AD(
		deflt = "false", 
		description = "allow-multiple-user-submissions-description", 
		name = "allow-multiple-user-submissions-name", 
		required = false
	)
	public boolean allowMultipleUserSubmissions();

}
