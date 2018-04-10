package com.gjd.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gjd.api.dao.CommentDao;
import com.gjd.api.dto.CommentUser;
import com.gjd.api.model.Comment;

@Service
public class CommentService {

	@Autowired
	private CommentDao commentDao;
	
	public int insert(Comment comment){
		return commentDao.insert(comment);
	}
	
	public List<CommentUser> queryAll(int nid){
		return commentDao.queryAll(nid);
	}
}
