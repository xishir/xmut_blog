package com.xmut.controller.api;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xmut.pojo.UserInfo;
import com.xmut.service.UserService;

import io.swagger.annotations.Api;


@RequestMapping("/api/user")
@RestController
@Api(value = "web", description = "user")
public class UserController {

    @Autowired
    private UserService service;

    /**
     * 更新用户信息
     * @param user_id 用户ID
     * @param nickName 昵称
     */
    @GetMapping("/updateUser/{id}")
    public void updateUser(@PathVariable("id") String user_id, @RequestParam("user_name") String user_name, @RequestParam("user_password") String user_password){
        service.updateUser(user_id,user_name,user_password);
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
     * 获取所有用户信息
     * @return
     */
    @GetMapping("/getUsers")
    public ArrayList<UserInfo> getUsers(){
        return service.getUsers();
    }

    /**
     * 删除用户
     * @param tel
     */
    @GetMapping("/deleteUserByUserId/{tel}")
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