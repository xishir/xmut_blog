package com.xmut.controller.api;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xmut.pojo.UserInfo;
import com.xmut.service.UserService;
import com.xmut.util.Msg;
import com.xmut.util.Result;

import io.swagger.annotations.Api;


@RequestMapping("/api/user")
@RestController
@Api(value = "web", description = "user")
public class UserController {

    @Autowired
    private UserService service;

    /**
     * 登录
     * @param map
     * @return
     */
    @PostMapping("/logincheck")
    public Msg logcheck(@RequestBody Map<String,Object> reqMap,HttpSession session){
    	if(service.checkLogin(reqMap))
    	{
    		session.setAttribute("isLogin", 1);
    		return Result.success();
    	}
    	return Result.error(500,"账号或密码错误");  
    }  
    
    /**
     * 注销
     * @param map
     * @return
     */
    @GetMapping("/logout")
    public Msg logcheck(HttpSession session){
    	session.removeAttribute("isLogin");
    	return Result.success();
    }  
}