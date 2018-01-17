package com.xmut.controller.api;

import java.util.ArrayList;
import java.util.Map;

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


@RequestMapping("/api/admin")
@RestController
@Api(value = "web", description = "admin")
public class AdminController {

    @Autowired
    private UserService service;

    /**
     * 登录
     * @param map
     * @return
     */
    @PostMapping("/logincheck")
    public Msg logcheck(@RequestBody Map<String,Object> reqMap){
    	System.out.println(reqMap.get("username"));
        return Result.success(reqMap);
    }  
}