package com.gjd.news.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.gjd.news.model.Comment;

@Mapper
public interface CommentMaper {

	@Insert("insert into comment(content,nid,uid) values(#{content},#{nid},#{uid})")
	int insert(Comment comment);
	
	@Select("select * from comment where nid=#{nid}")
	List<Comment> queryAll(int nid);
}
