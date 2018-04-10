package com.gjd.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gjd.api.dao.UserDao;
import com.gjd.api.model.User;


@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	public int insert(User user) {
		return userDao.insert(user);
	}

	public int update(User user) {
		return userDao.update(user);
	}

	public User query(String name,String password) {
		return userDao.query(name,password);
	}
	
	public String test(String name) {
		return userDao.test(name);
	}
}
