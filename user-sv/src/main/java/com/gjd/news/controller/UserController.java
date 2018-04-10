package com.gjd.news.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gjd.news.model.User;
import com.gjd.news.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("insert")
	public int insert(@RequestBody User user) {
		
		return userService.insert(user);
	}

	@PostMapping("update")
	public int update(@RequestBody User user) {
		
		return userService.update(user);
	}
	
	@GetMapping("query")
	public User query(String name,String password) {
		User user = userService.query(name, password);
		return user;
	}
	@GetMapping("find")
	public String query(int id){
		User user = userService.queryById(id);
		return user.getName();
	}
	
	@Value("${server.port}")
	String port;
	
	@RequestMapping("/hi")
	public String hello(String name){
		 return "hi "+name+",i am from port:" +port;
	}
}