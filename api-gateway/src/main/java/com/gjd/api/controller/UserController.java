package com.gjd.api.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gjd.api.common.UserContext;
import com.gjd.api.model.User;
import com.gjd.api.service.UserService;



@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userService;

	
	@RequestMapping("register")
	public String register(@ModelAttribute User user){
		if(user.getName()==null){
			return "register";
		}
		userService.insert(user);
		return "login";
	}
	
	@RequestMapping(value="login",method={RequestMethod.POST,RequestMethod.GET})
	public String login(String name,String password,ModelMap map,HttpServletRequest request){
		if(name== null){
			return "login";
		}
		User user = userService.query(name, password);
		HttpSession session = request.getSession();
		session.setAttribute("username", user.getName());
		session.setAttribute("uid", user.getId());
		return "redirect:/news/list";
	}
	
	@RequestMapping("update")
	public String update(HttpServletRequest  request,String name){
		
		String value = userService.test(name);
		request.setAttribute("name", value);
		return "login";
	}
	
	
	
}
