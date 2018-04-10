package com.gjd.news.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.gjd.news.model.News;

@Mapper
public interface NewsMapper {

	@Insert("insert into news(title,content,uid) values(#{title},#{content},#{uid})")
	int insert(News news);
	
	@Select("select * from news where nid=#{id}")
	News queryOne(int id);
	
	@Select("select * from news")
	List<News> queryAll();
	
}
