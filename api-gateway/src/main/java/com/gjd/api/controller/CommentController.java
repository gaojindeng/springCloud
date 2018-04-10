package com.gjd.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gjd.api.model.Comment;
import com.gjd.api.service.CommentService;


@Controller
@RequestMapping("comment")
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@RequestMapping("/add")
	public String insert(Comment comment){
		int flag = commentService.insert(comment);
		if(flag != 0){
			return "redirect:/news/query?id="+comment.getNid();
		}
		return "list";
	}
	
}
