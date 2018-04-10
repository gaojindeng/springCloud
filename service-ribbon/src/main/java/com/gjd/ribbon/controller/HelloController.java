package com.gjd.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gjd.ribbon.service.HelloService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class HelloController {
	
	@Autowired
	private HelloService helloService;
	
	@HystrixCommand(fallbackMethod="hisError")	//服务不可用就调用其他错误提示方法，如果启动负载均衡了，那调用挂掉的服务会报错
	@RequestMapping(value="/hi",method=RequestMethod.GET)
	public String hello(@RequestParam String name){
		return helloService.hiService(name);
	}
	
	
	public String hisError(String name){
		return "hi,"+name+",sorry,error!";
	}
}
