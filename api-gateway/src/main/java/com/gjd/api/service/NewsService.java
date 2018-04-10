package com.gjd.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gjd.api.dao.NewsDao;
import com.gjd.api.dto.UserNews;
import com.gjd.api.model.News;


@Service
public class NewsService {
	@Autowired
	private NewsDao newsDao;
	
	public List<News> list(){
		return newsDao.queryAll();
	}
	
	public int insert(News news){
		return newsDao.insert(news);
	}
	
	public UserNews queryOne(int id){
		return newsDao.queryOne(id);
	}
}
