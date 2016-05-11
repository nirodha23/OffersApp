package com.technolabs.communityinfo.jms;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
@Service
public class ExportMessageSender {
	@Autowired
	private JmsTemplate jmsTemplate;
	@Autowired
	private Queue exportMessagesQueue;
	public void sendExportMessage(String message){
		System.out.println("Sending message to queue "+ message);
		if(jmsTemplate == null)
			System.out.println("jmsTemplate null");
		if(exportMessagesQueue == null)
			System.out.println("exportMessagesQueue null");
		jmsTemplate.convertAndSend(exportMessagesQueue, message);

	}
	
	public void setJmsTemplate(JmsTemplate tmpl)
	{
		this.jmsTemplate = tmpl;
	}

	public void setExportMessagesQueue(Queue exportMessagesQueue) {
		this.exportMessagesQueue = exportMessagesQueue;
	}
	
	
}
