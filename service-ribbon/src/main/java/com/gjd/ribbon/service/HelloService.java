package com.gjd.ribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

	@Autowired
	private RestTemplate restTemplate;
	
	public String hiService(String name){
		return restTemplate.getForObject("http://service-hi/hi?name="+name, String.class);
		
	}
}
