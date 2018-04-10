package com.gjd.news.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gjd.news.dao.UserDao;
import com.gjd.news.dto.CommentUser;
import com.gjd.news.mapper.CommentMaper;
import com.gjd.news.model.Comment;

@Service
public class CommentService {

	@Autowired
	private CommentMaper commentMaper;
	
	@Autowired
	private UserDao userDao;
	
	public int insert(Comment comment){
		return commentMaper.insert(comment);
	}
	
	public List<CommentUser> queryAll(int nid){
		List<Comment> commonts = commentMaper.queryAll(nid);
		List<CommentUser> commentUsers = new ArrayList<>();
		for (Comment commont : commonts) {
			String username = userDao.query(commont.getUid());
			CommentUser commentUser = new CommentUser(commont,username);
			commentUsers.add(commentUser);
		}
		return commentUsers;
	}
}
