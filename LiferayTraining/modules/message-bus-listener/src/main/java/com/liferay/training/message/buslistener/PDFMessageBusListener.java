package com.liferay.training.message.buslistener;

import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.kernel.repository.model.FileVersion;

import org.osgi.service.component.annotations.Component;

@Component (
    immediate = true,
    property = {
    	"destination.name=" + DestinationNames.DOCUMENT_LIBRARY_PDF_PROCESSOR
    },
    service = MessageListener.class
)
public class PDFMessageBusListener implements MessageListener {

	@Override
	public void receive(Message message)
		throws MessageListenerException {

		Object[] payload = (Object[])message.getPayload();
		
		FileVersion fileVersion = (FileVersion)payload[1];

		System.out.println("Title=" + fileVersion.getTitle());
	}

}
