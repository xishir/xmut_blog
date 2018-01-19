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

    @Insert("INSERT INTO k_user(use_name,use_password) VALUES (#{use_name},md5(#{use_password}))")
    void createUser(Map<String, Object> reqMap);

    @Select("select * FROM k_user WHERE user_id = #{user_id}")
    UserInfo getUser(@Param("user_id") Integer user_id);
    
    @Select("select about FROM k_user WHERE user_name = #{user_name}")
    String getUserByName(@Param("user_name") String user_name);
    
    @Select("select * FROM k_user ")
    ArrayList<UserInfo> getUsers();

    @Update("UPDATE k_user SET user_password=md5(#{user_password}),about=#{about} WHERE user_name = #{user_name}")
    void updateUser(Map<String,Object> reqMap);

    @Delete("DELETE FROM k_user WHERE user_id = #{user_id}")
    void deleteUserByUserId(UserInfo userInfo);
    
    @Select("select count(*) FROM k_user where user_name=#{user_name} and user_password=md5(#{user_password})")
    Integer checkLogin(Map<String, Object> reqMap);
}
