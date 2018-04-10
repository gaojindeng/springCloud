package com.gjd.api.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gjd.api.common.UserContext;
import com.gjd.api.dto.CommentUser;
import com.gjd.api.dto.UserNews;
import com.gjd.api.model.Comment;
import com.gjd.api.model.News;
import com.gjd.api.model.User;
import com.gjd.api.service.CommentService;
import com.gjd.api.service.NewsService;


@Controller
@RequestMapping("news")
public class NewsController {
	
	@Autowired
	private NewsService newsService;
	
	@Autowired
	private CommentService commentService;
	
	@RequestMapping("list")
	public String list(HttpServletRequest request){
		List<News> list = newsService.list();
		request.setAttribute("list", list);
		User user = UserContext.getUser();
		request.setAttribute("user", user);
		return "news";
	}
	
	@RequestMapping("add")
	public String insert(News news){
		int flag = newsService.insert(news);
		if(flag!=0){
			return "list";
		}
		return "add";
	}
	
	@RequestMapping("query")
	public String insert(int id,HttpServletRequest request){
		UserNews news = newsService.queryOne(id);
		request.setAttribute("news", news);
		List<CommentUser> commonts = commentService.queryAll(news.getNid());
		request.setAttribute("commonts", commonts);
		return "new";
	}
	
}
