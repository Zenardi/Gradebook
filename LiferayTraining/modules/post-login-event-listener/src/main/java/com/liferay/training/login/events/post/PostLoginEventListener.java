package com.liferay.training.login.events.post;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailService;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserService;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author liferay
 */
@Component(immediate = true, property = { "key=login.events.post" }, service = LifecycleAction.class)
public class PostLoginEventListener implements LifecycleAction {

	@Override
	public void processLifecycleEvent(LifecycleEvent lifecycleEvent) throws ActionException {

		try {

			User user = _userService.getCurrentUser();

			MailMessage message = new MailMessage();

			message.setSubject("Security Alert");
			message.setBody("Liferay has detected that you logged in at " + user.getLastLoginDate());

			InternetAddress toAddress = new InternetAddress(user.getEmailAddress());
			InternetAddress fromAddress = new InternetAddress("do-not-reply@liferay.com");

			message.setTo(toAddress);
			message.setFrom(fromAddress);

			_mailService.sendEmail(message);

		} catch (PortalException e) {
			_log.error(e, e);
		} catch (AddressException e) {

			_log.error(e, e);
		}

	}

	private static final Log _log = LogFactoryUtil.getLog(PostLoginEventListener.class);

	@Reference
	protected UserService _userService;

	@Reference
	protected MailService _mailService;
}
