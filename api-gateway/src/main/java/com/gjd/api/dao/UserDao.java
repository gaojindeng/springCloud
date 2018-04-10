package com.gjd.api.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.gjd.api.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Repository

public class UserDao {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public int insert(User user){
		return restTemplate.postForObject("http://user/user/insert", user, Integer.class);
	}
	
	public int update(User user){
		return restTemplate.postForObject("http://user/user/update", user, Integer.class);
	}
	
	public User query(String name,String password){
		Map<String,String> map = new HashMap<>();
		map.put("name", name);
		map.put("password", password);
		User response = restTemplate.getForObject("http://user/user/query?name={name}&password={password}", User.class, map);
		return response;
	}
	
	public String test(String name){
		return restTemplate.getForObject("http://user/user/hi?name="+name, String.class);
	}
}
