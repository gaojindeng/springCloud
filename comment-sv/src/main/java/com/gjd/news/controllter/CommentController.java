package com.gjd.news.controllter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gjd.news.common.RestResponse;
import com.gjd.news.dto.CommentUser;
import com.gjd.news.model.Comment;
import com.gjd.news.service.CommentService;

@RestController
@RequestMapping("comment")
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@RequestMapping("/insert")
	public int insert(@RequestBody Comment comment){
		
		return commentService.insert(comment);
	}
	
	@RequestMapping("/list")
	public List<CommentUser> queryAll(int nid){
		return commentService.queryAll(nid);
	}
}
