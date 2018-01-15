package com.xmut.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmut.dao.MybatisUserAnnotaionMapper;
import com.xmut.pojo.UserInfo;

@Service
public class MybatisService {

    @Autowired
    private MybatisUserAnnotaionMapper annotaionMapper;


    public void updateUser(String user_id, String nickName) {
        annotaionMapper.updateUser(user_id,nickName);
    }

    public UserInfo getUser(Integer id) {
        return annotaionMapper.getUser(id);
    }

    public void deleteUserByUserId(UserInfo userInfo) {
        annotaionMapper.deleteUserByUserId(userInfo);
    }

    public void createUser(Map<String, Object> reqMap) {
        annotaionMapper.createUser(reqMap);
    }
}