package com.technolabs.communityinfo.dao;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="messages")
public class Messages {
	private int count;
	private List<Message> messages;

	public Messages() {}
	
	public Messages(List<Message> messages) {
		this.messages = messages;
		this.count = messages.size();
	}

	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	@XmlElement(name="employee")
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	
}
