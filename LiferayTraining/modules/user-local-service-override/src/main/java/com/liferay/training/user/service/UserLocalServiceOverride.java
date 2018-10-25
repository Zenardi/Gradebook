
package com.liferay.training.user.service;

import com.liferay.portal.kernel.service.UserLocalServiceWrapper;

import java.util.Locale;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.service.component.annotations.Component;

/**
 * @author ZEE8CA
 */
@Component(immediate = true, property = {}, service = ServiceWrapper.class)
public class UserLocalServiceOverride extends UserLocalServiceWrapper {

	public UserLocalServiceOverride() {

		super(null);
	}

	@Override
	public User addUserWithWorkflow(
		long creatorUserId, long companyId, boolean autoPassword,
		String password1, String password2, boolean autoScreenName,
		String screenName, String emailAddress, long facebookId, String openId,
		Locale locale, String firstName, String middleName, String lastName,
		long prefixId, long suffixId, boolean male, int birthdayMonth,
		int birthdayDay, int birthdayYear, String jobTitle, long[] groupIds,
		long[] organizationIds, long[] roleIds, long[] userGroupIds,
		boolean sendEmail, ServiceContext serviceContext)
		throws PortalException {

		if (emailAddress.contains("@gmail.com") ||
			emailAddress.contains("@yahoo.com") ||
			emailAddress.contains("@aol.com") ||
			emailAddress.contains("@hotmail.com")) {

			System.out.println(
				"You must enter a work email address. User will not be added.");

			throw new PortalException("You must enter a work email address.");
		}

		return super.addUserWithWorkflow(
			creatorUserId, companyId, autoPassword, password1, password2,
			autoScreenName, screenName, emailAddress, facebookId, openId,
			locale, firstName, middleName, lastName, prefixId, suffixId, male,
			birthdayMonth, birthdayDay, birthdayYear, jobTitle, groupIds,
			organizationIds, roleIds, userGroupIds, sendEmail, serviceContext);
	}

}
