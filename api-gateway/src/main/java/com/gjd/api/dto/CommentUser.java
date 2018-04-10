package com.gjd.api.dto;

import com.gjd.api.model.Comment;

public class CommentUser {
	private String content;
	private int nid;
	private String name;
	public CommentUser(Comment commont, String username) {
		this.content = commont.getContent();
		this.nid = commont.getNid();
		this.name = username;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
