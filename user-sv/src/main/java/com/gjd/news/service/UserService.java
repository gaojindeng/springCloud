package com.gjd.news.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gjd.news.dao.UserMapper;
import com.gjd.news.model.User;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	public int insert(User user) {
		return userMapper.insert(user);
	}

	public int update(User user) {
		return userMapper.update(user);
	}

	public User query(String name,String password) {
		return userMapper.query(name,password);
	}
	
	public User queryById(int id){
		return userMapper.queryById(id);
	}
}