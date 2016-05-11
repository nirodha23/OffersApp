package com.technolabs.communityinfo.jms;

import java.util.concurrent.TimeUnit;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Service;

@Service
public class ExportMessageListener implements MessageListener {

	@Override
	public void onMessage(Message message) {
		
		if (message instanceof TextMessage)
		{
			try
			{
				
				String msgText = ((TextMessage) message).getText();
				System.out.println("Received message : "+msgText);

				/* call the method to do export processing */
				System.out.println("Processing export request");
				
				Thread.sleep(20000);
				System.out.println("Done - Exported");

			}
			catch (JMSException jmsEx_p)
			{
				String errMsg = "An error occurred extracting message";
				System.out.println(errMsg);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
