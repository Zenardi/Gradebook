
package com.liferay.training.gradebook.service.validation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.training.gradebook.exception.AssignmentValidationException;

public class AssignmentValidator {

	/**
	 * Returns <code>true</code> if the given fields are valid for an
	 * assignment.
	 * 
	 * @param titleMap
	 * @param description
	 * @param dueDate
	 * @param errors
	 * @return boolean <code>true</code> if assignment is valid, otherwise
	 *         <code>false</code>
	 */
	public static boolean isAssignmentValid(
		final Map<Locale, String> titleMap, final String description,
		final Date dueDate, final List<String> errors) {

		boolean result = true;

		result &= isTitleValid(titleMap, errors);
		result &= isDueDateValid(dueDate, errors);
		result &= isDescriptionValid(description, errors);

		return result;
	}

	/**
	 * Returns <code>true</code> if description is valid for an assignment. If
	 * not valid, an error message is added to the errors list.
	 * 
	 * @param description
	 * @param errors
	 * @return boolean <code>true</code> if description is valid, otherwise
	 *         <code>false</code>
	 */
	public static boolean isDescriptionValid(
		final String description, final List<String> errors) {

		boolean result = true;

		if (Validator.isBlank(HtmlUtil.stripHtml(description))) {
			errors.add("error.assignment-description-empty");
			result = false;
		}

		return result;
	}

	/**
	 * Returns <code>true</code> if due date is valid for an assignment. If not
	 * valid, an error message is added to the errors list.
	 * 
	 * @param dueDate
	 * @param errors
	 * @return boolean <code>true</code> if due date is valid, otherwise
	 *         <code>false</code>
	 */
	public static boolean isDueDateValid(
		final Date dueDate, final List<String> errors) {

		boolean result = true;

		if (Validator.isNull(dueDate)) {
			errors.add("error.assignment-date-empty");
			result = false;
		}

		return result;
	}

	/**
	 * Returns <code>true</code> if title is valid for an assignment. If not
	 * valid, an error message is added to the errors list.
	 * 
	 * @param titleMap
	 * @param errors
	 * @return boolean <code>true</code> if the title is valid, otherwise
	 *         <code>false</code>
	 */
	public static boolean isTitleValid(
		final Map<Locale, String> titleMap, final List<String> errors) {

		boolean result = true;

		// verify the map has something

		if (MapUtil.isEmpty(titleMap)) {
			errors.add("error.assignment-title-empty");
			result = false;
		}
		else {

			// get the default locale

			Locale defaultLocale = LocaleUtil.getSiteDefault();

			result = isTitleValid(titleMap.get(defaultLocale), errors);
		}

		// get the default title string

		return result;
	}

	/**
	 * Returns <code>true</code> if title is valid for an assignment.
	 * 
	 * @param title
	 * @param errors
	 * @return boolean <code>true</code> if title is valid, otherwise
	 *         <code>false</code>
	 */
	public static boolean isTitleValid(
		final String title, final List<String> errors) {

		boolean result = true;

		if ((Validator.isBlank(title))) {
			errors.add("error.assignment-title-empty");
			result = false;
		}

		return result;
	}

	/**
	 * Validates assignment values and throws
	 * {AssignmentValidationExceptionException} if the assignment values are not
	 * valid.
	 * 
	 * @param titleMap
	 * @param description
	 * @param dueDate
	 * @throws AssignmentValidationExceptionException
	 */
	public static void validate(
		Map<Locale, String> titleMap, String description, Date dueDate)
		throws AssignmentValidationException {

		List<String> errors = new ArrayList<>();
		if (!isAssignmentValid(titleMap, description, dueDate, errors)) {
			throw new AssignmentValidationException(errors);
		}
	}
}
