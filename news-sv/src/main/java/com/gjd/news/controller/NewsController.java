package com.gjd.news.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gjd.news.common.RestResponse;
import com.gjd.news.dto.UserNews;
import com.gjd.news.model.News;
import com.gjd.news.service.NewsService;

@RestController
@RequestMapping("news")
public class NewsController {
	
	@Autowired
	private NewsService newsService;
	
	@RequestMapping("list")
	public List<News> list(){
		List<News> list = newsService.list();
		return list;
	}
	
	@RequestMapping("insert")
	public int insert(@RequestBody News news){
		
		return newsService.insert(news);
	}
	
	@RequestMapping("query")
	public UserNews queryOne(int id){
		UserNews news = newsService.queryOne(id);
		return news;
	}
	
	@RequestMapping("test")
	@ResponseBody
	public String queryOne(String name){
		String news = newsService.test(name);
		return news;
	}
	
}
