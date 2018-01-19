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
import com.xmut.service.UserService;
import com.xmut.util.Msg;
import com.xmut.util.Result;

import io.swagger.annotations.Api;


@RequestMapping("/api/article")
@RestController
@Api(value = "web", description = "article")
public class ArticleController {

    @Autowired
    private ArticleService service;

    /**
     * 获取文章列表
     * @param page 页数
     * @return
     */
    @GetMapping("/list/{page}")
    public Msg getList(@PathVariable("page")  Integer id){
        return Result.success(service.getList(id));
    }
    
    /**
     * 获取文章详情
     * @param id 文章id
     * @return
     */
    @GetMapping("/info/{id}")
    public Msg getInfo(@PathVariable("id")  Integer id){
        return Result.success(service.getInfo(id.toString()));
    }
    
    /**
     * 点赞
     * @param id 文章id
     * @return
     */
    @GetMapping("/star/{id}")
    public Msg getStar(@PathVariable("id")  String id){
    	service.addStar(id.toString());
        return Result.success();
    }
    
    /**
     * 获取页数
     * @return
     */
    @GetMapping("/pageNum")
    public Msg pageNum(){
        return Result.success(service.getPageNum());
    }


}