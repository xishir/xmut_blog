package com.xmut.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xmut.pojo.UserInfo;
import com.xmut.service.MybatisService;


@RequestMapping("/mybatis")
@RestController
public class MybatisController {

    @Autowired
    private MybatisService service;

    /**
     * 更新用户信息
     * @param user_id 用户ID
     * @param nickName 昵称
     */
    @PutMapping("/updateUser/{id}")
    public void updateUser(@PathVariable("id") String user_id, @RequestParam("nickName") String nickName){
        service.updateUser(user_id,nickName);
    }

    /**
     * 获取用户信息
     * @param id 用户Id
     * @return
     */
    @GetMapping("/getUser/{id}")
    public UserInfo getUser(@PathVariable("id")  Integer id){
        return service.getUser(id);
    }

    /**
     * 删除用户
     * @param tel
     */
    @DeleteMapping("/deleteUserByUserId/{tel}")
    public void deleteUserByUserId(@PathVariable("tel")  String tel){
        UserInfo user  = new UserInfo();
        user.setTel(tel);
        service.deleteUserByUserId(user);
    }

    /**
     * 使用@RequestBody获取参数，用map类型接收，再取出
     * @param reqMap
     */
    @PostMapping("/createUserByMap")
    public void createUserByMap(@RequestBody Map<String,Object> reqMap){
    	System.out.println(reqMap);
        service.createUser(reqMap);
    }


}