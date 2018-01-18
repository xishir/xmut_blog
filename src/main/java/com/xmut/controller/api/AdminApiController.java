package com.xmut.controller.api;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xmut.service.ArticleService;
import com.xmut.service.CommentService;
import com.xmut.service.TagService;
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
    
    @Autowired
    private CommentService commentService;
    
    @Autowired
    private TagService tagService;

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
    
    /**
     * 编辑文章
     * @return
     */
    @PostMapping("/article/edit")
    public Msg edit(@RequestBody Map<String,Object> reqMap){
    	System.out.println("编辑文章");
        return Result.success(articleService.editArticle(reqMap));
    }
    
    /**
     * 删除文章
     * @return
     */
    @GetMapping("/article/del/{id}")
    public Msg del(@PathVariable("id")  String id){
    	System.out.println("删除文章");
    	articleService.deleteArticleById(id);
        return Result.success();
    }
    
    /**
     * 删除评论
     * @return
     */
    @GetMapping("/comment/del/{id}")
    public Msg delComment(@PathVariable("id")  String id){
    	System.out.println("删除评论");
    	commentService.deleteCommentById(id);
        return Result.success();
    }
    
    /**
     * 主页数据
     * @return
     */
    @GetMapping("/num")
    public Msg index(){
    	Map map=new HashMap();  
    	map.put("articleNum", articleService.getArticleNum());
    	map.put("commentNum", commentService.getCommentNum());
    	map.put("tagNum", tagService.getTagNum());
    	System.out.println("获取后台主页数据");
        return Result.success(map);
    }
    
    
}