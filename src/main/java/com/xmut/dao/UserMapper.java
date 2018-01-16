package com.xmut.dao;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.xmut.pojo.UserInfo;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO blog.k_user(use_name,use_password) VALUES (#{use_name},md5(#{use_password}))")
    void createUser(Map<String, Object> reqMap);

    @Select("select tel,nickname,password FROM blog.k_user WHERE user_id = #{user_id}")
    UserInfo getUser(@Param("user_id") Integer user_id);
    
    @Select("select tel,nickname,password FROM blog.k_user ")
    ArrayList<UserInfo> getUsers();

    @Update("UPDATE blog.k_user SET user_name = #{user_name},user_password=#{user_password} WHERE user_id = #{user_id}")
    void updateUser(@Param("user_id") String user_id, @Param("user_name") String user_name, @Param("user_password") String user_password);

    @Delete("DELETE FROM blog.k_user WHERE user_id = #{user_id}")
    void deleteUserByUserId(UserInfo userInfo);
}