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
import com.xmut.service.ArticleService;
import com.xmut.service.CommentService;
import com.xmut.service.UserService;
import com.xmut.util.Msg;
import com.xmut.util.Result;

import io.swagger.annotations.Api;


@RequestMapping("/api/comment")
@RestController
@Api(value = "web", description = "comment")
public class CommentController {

    @Autowired
    private CommentService service;

    /**
     * 获取评论列表
     * @param id 文章id
     * @return
     */
    @GetMapping("/list/{id}")
    public Msg getList(@PathVariable("id")  String id){
        return Result.success(service.getComments(id));
    }
    
    /**
     * 添加评论
     * @return
     */
    @PostMapping("/create")
    public Msg create(@RequestBody Map<String,Object> reqMap){
    	System.out.println("添加评论");
    	service.createcomment(reqMap);
        return Result.success();
    }
    
    /**
     * 点赞
     * @param id 评论id
     * @return
     */
    @GetMapping("/star/{id}")
    public Msg getStar(@PathVariable("id")  String id){
    	service.addStar(id.toString());
        return Result.success();
    }
    
    /**
     * Diss
     * @param id 评论id
     * @return
     */
    @GetMapping("/diss/{id}")
    public Msg getDiss(@PathVariable("id")  String id){
    	service.addDiss(id.toString());
        return Result.success();
    }


}