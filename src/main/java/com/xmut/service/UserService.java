package com.xmut.service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmut.dao.UserMapper;
import com.xmut.pojo.UserInfo;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;


    public void updateUser(String user_id, String nickName) {
    	userMapper.updateUser(user_id,nickName);
    }

    public UserInfo getUser(Integer id) {
        return userMapper.getUser(id);
    }
    
    public ArrayList<UserInfo> getUsers() {
        return userMapper.getUsers();
    }

    public void deleteUserByUserId(UserInfo userInfo) {
    	userMapper.deleteUserByUserId(userInfo);
    }

    public void createUser(Map<String, Object> reqMap) {
    	userMapper.createUser(reqMap);
    }
}