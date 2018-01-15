package com.xmut.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.xmut.pojo.UserInfo;

@Mapper
public interface MybatisUserAnnotaionMapper {

    @Insert("INSERT INTO keshe.tp_user(tel,password,nickname,secret) VALUES (#{tel},md5(#{pwd}),#{tel},'')")
    void createUser(Map<String, Object> reqMap);

    @Select("select tel,nickname,password FROM keshe.tp_user WHERE user_id = #{id}")
    UserInfo getUser(@Param("id") Integer id);

    @Update("UPDATE keshe.tp_user SET nickname = #{nickName} WHERE user_id = #{userId}")
    void updateUser(@Param("userId") String user_id, @Param("nickName") String nickName);

    @Delete("DELETE FROM keshe.tp_user WHERE tel = #{tel}")
    void deleteUserByUserId(UserInfo userInfo);
}