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


    public void updateUser(Map<String,Object> reqMap) {
    	userMapper.updateUser(reqMap);
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
    
    public boolean checkLogin(Map<String, Object> reqMap){
    	System.out.println("检查用户名密码");
    	if(userMapper.checkLogin(reqMap)>0)
    		return true;
    	else
    		return false;
    }
}
