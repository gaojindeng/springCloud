package com.gjd.news.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gjd.news.dao.UserDao;
import com.gjd.news.dto.UserNews;
import com.gjd.news.mapper.NewsMapper;
import com.gjd.news.model.News;
import com.gjd.news.model.User;

@Service
public class NewsService {

	@Autowired
	private NewsMapper newsMapper;
	
	@Autowired
	private UserDao userDao;
	
	public List<News> list(){
		return newsMapper.queryAll();
	}
	
	public int insert(News news){
		return newsMapper.insert(news);
	}
	
	public UserNews queryOne(int id){
		News news = newsMapper.queryOne(id);
		String username = userDao.query(news.getUid());
		UserNews userNews = new UserNews(news,username);
		return userNews;
	}
	
	public String test(String name){
		return userDao.test(name);
	}
}
