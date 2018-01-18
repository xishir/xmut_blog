package com.xmut.controller.api;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xmut.service.ArticleService;
import com.xmut.service.UserService;
import com.xmut.util.Msg;
import com.xmut.util.Result;

import io.swagger.annotations.Api;


@RequestMapping("/api/admin")
@RestController
@Api(value = "web", description = "admin")
public class AdminApiController {

    @Autowired
    private UserService service;
    
    @Autowired
    private ArticleService articleService;

    /**
     * 登录
     * @param map
     * @return
     */
    @PostMapping("/logincheck")
    public Msg logcheck(@RequestBody Map<String,Object> reqMap,HttpSession session){
    	System.out.println(session.getAttribute("isLogin"));
    	session.setAttribute("isLogin", 1);
        return Result.success(session.getAttribute("isLogin"));
    }   
    
    /**
     * 添加文章
     * @return
     */
    @PostMapping("/article/create")
    public Msg create(@RequestBody Map<String,Object> reqMap){
    	System.out.println("添加文章");
        return Result.success(articleService.createArticle(reqMap));
    }
}