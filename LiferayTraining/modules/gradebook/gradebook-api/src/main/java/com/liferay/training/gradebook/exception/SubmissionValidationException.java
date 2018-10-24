/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
package com.liferay.training.gradebook.exception;

import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.ListUtil;

import aQute.bnd.annotation.ProviderType;

/**
 * @author Brian Wing Shun Chan
 */
@ProviderType
public class SubmissionValidationException extends PortalException {

	public SubmissionValidationException() {
	}

	public SubmissionValidationException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public SubmissionValidationException(Throwable cause) {
		super(cause);
	}
	
	public SubmissionValidationException(String...errors) {
		this(ListUtil.toList(errors));
	}
	
	/**
	 * Custom constructor for validation
	 * @param errors
	 */
	public SubmissionValidationException(List<String> errors) {
		super(String.join(",", errors));
		_errors = errors;
	}
	
	public List<String> getErrors() {
		return _errors;
	}
	
	private List<String> _errors;
}