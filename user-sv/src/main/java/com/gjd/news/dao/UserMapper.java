package com.gjd.news.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.gjd.news.model.User;

@Mapper
public interface UserMapper {
	
	@Insert("insert into user(id,name,password) values(#{id},#{name},#{password})")
	int insert(User user);
	
	@Update("update user set name=#{name},password=#{password} where id=#{id}")
	int update(User user);
	
	@Select("select * from user where name=#{name} and password=#{password}")
	User query(@Param("name") String name,@Param("password") String password);
	
	@Select("select * from user where id=#{id}")
	User queryById(int id);
	
	
}
