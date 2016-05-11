package com.technolabs.communityinfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.technolabs.communityinfo.dao.Message;
import com.technolabs.communityinfo.dao.MessagesDao;
import com.technolabs.communityinfo.dao.User;
import com.technolabs.communityinfo.dao.UsersDao;

@Service("usersService")
public class UsersService {
	
	@Autowired
	private UsersDao usersDao;
	
	@Autowired
	private MessagesDao messagesDao;
	
	public void create(User user) {
		usersDao.create(user);
	}


	public boolean exists(String username) {
		return usersDao.exists(username);
	}

	@Secured("ROLE_ADMIN")
	public List<User> getAllUsers() {
		return usersDao.getAllUsers();
	}
	
	public void sendMessage(Message message) {
		messagesDao.saveOrUpdate(message);
	}
	
	public User getUser(String username) {
		return usersDao.getUser(username);
	}


	public List<Message> getMessages(String username) {
		return messagesDao.getMessages(username);
	}

}
