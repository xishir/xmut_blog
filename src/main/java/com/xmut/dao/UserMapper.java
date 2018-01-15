package com.xmut.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.xmut.pojo.User;

@Mapper
public interface UserMapper {
	@Select("select * from user where name=#{name}")
	@Results({ 
		@Result(column = "id", property = "id"), 
		@Result(column = "name", property = "name"),
		@Result(column = "pwd", property = "pwd") })
	User findUserByName(@Param("name") String name);
}