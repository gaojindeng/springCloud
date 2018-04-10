package com.gjd.news.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;

@Repository
public class UserDao {
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	public String query(int id){
		Map<String,Integer> map = new HashMap<>();
		map.put("id", id);
		String response = restTemplate.getForObject("http://user/user/find?id={id}", String.class, map);
		return response;
	}
	
	
}
