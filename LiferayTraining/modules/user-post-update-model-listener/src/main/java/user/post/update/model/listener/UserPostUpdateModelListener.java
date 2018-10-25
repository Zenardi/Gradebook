
package user.post.update.model.listener;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailService;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.model.User;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = ModelListener.class)
public class UserPostUpdateModelListener extends BaseModelListener<User> {

	@Override
	public void onAfterUpdate(User model) throws ModelListenerException {
		try {
			MailMessage message = new MailMessage();

			message.setSubject("Security Alert: Account Settings");
			message.setBody("Liferay has detected that your account settings has been changed.");

			InternetAddress toAddress = new InternetAddress(model.getEmailAddress());
			InternetAddress fromAddress = new InternetAddress("do-not-reply@liferay.com");

			message.setTo(toAddress);
			message.setFrom(fromAddress);

			_mailService.sendEmail(message);
		} catch (AddressException e) {
			_log.error(e, e);
		}
	}
	
	  private static final Log _log = LogFactoryUtil.getLog(UserPostUpdateModelListener.class);

      @Reference
      protected MailService _mailService;
	
}