package com.xmut.controller;  
    
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xmut.pojo.UserInfo;
import com.xmut.service.UserService;  
  
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 添加用户
     * @param tel 注册手机号
     * @param pwd 设置密码
     */
    @PostMapping("/createUser")
    public void createUser(@RequestParam("tel") String tel, @RequestParam("pwd") String pwd){
        userService.createUser(tel,pwd);
    }

    /**
     * 更新用户信息
     * @param user_id 用户ID
     * @param nickName 昵称
     */
    @PutMapping("/updateUser/{id}")
    public void updateUser(@PathVariable("id") String user_id, @RequestParam("nickName") String nickName){
        userService.updateUser(user_id,nickName);
    }

    /**
     * 获取用户信息
     * @param id 用户Id
     * @return
     */
    @GetMapping("/getUser/{id}")
    public UserInfo getUser(@PathVariable("id")  Integer id){
        return userService.getUser(id);
    }

    @DeleteMapping("/deleteUserByUserId/{id}")
    public void deleteUserByUserId(@PathVariable("id")  Integer id){
        userService.deleteUserByUserId(id);
    }
    
    /**
     * 添加用户2
     * @param userInfo
     */
    @PostMapping("/createUser2")
    public String createUser2(@Valid UserInfo userInfo, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return bindingResult.getFieldError().getDefaultMessage();
        }
        userService.createUser(userInfo.getTel(),userInfo.getPassWord());
        return "OK";
    }
}