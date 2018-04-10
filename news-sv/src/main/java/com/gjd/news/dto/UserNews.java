package com.gjd.news.dto;

import com.gjd.news.model.News;
import com.gjd.news.model.User;

public class UserNews {
	private int nid;
	private String title;
	private String content;
	private String name;
	public UserNews(News news, String username) {
		this.nid = news.getNid();
		this.title = news.getTitle();
		this.content = news.getContent();
		this.name = username;
	}
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
