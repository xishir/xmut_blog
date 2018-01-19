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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xmut.pojo.UserInfo;
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
     * 更新用户信息
     * @param nickName 昵称
     */
    @PostMapping("/updateUser")
    public Msg updateUser(@RequestBody Map<String,Object> reqMap){
        service.updateUser(reqMap);
    	return Result.success();
    }

    /**
     * 获取用户信息
     * @param id 用户Id
     * @return
     */
    @GetMapping("/getUser/{id}")
    public Msg getUser(@PathVariable("id")  Integer id){
        return Result.success(service.getUser(id));
    }
    
    /**
     * 获取所有用户信息
     * @return
     */
    @GetMapping("/getUsers")
    public Msg getUsers(){
        return Result.success(service.getUsers());
    }

    /**
     * 删除用户
     * @param tel
     */
    @GetMapping("/deleteUserByUserId/{tel}")
    public void deleteUserByUserId(@PathVariable("tel")  String tel){
        UserInfo user  = new UserInfo();
        //user.setTel(tel);
        service.deleteUserByUserId(user);
    }

    /**
     * 使用@RequestBody获取参数，用map类型接收，再取出
     * @param reqMap
     */
    @PostMapping("/createUserByMap")
    public void createUserByMap(@RequestBody Map<String,Object> reqMap){
        service.createUser(reqMap);
    }
    
    /**
     * 添加文章
     * @return
     */
    @PostMapping("/article/create")
    public Msg create(@RequestBody Map<String,Object> reqMap){
        return Result.success(articleService.createArticle(reqMap));
    }
    
    /**
     * 编辑文章
     * @return
     */
    @PostMapping("/article/edit")
    public Msg edit(@RequestBody Map<String,Object> reqMap){
        return Result.success(articleService.editArticle(reqMap));
    }
    
    /**
     * 删除文章
     * @return
     */
    @GetMapping("/article/del/{id}")
    public Msg del(@PathVariable("id")  String id){
    	articleService.deleteArticleById(id);
        return Result.success();
    }
    
    /**
     * 删除评论
     * @return
     */
    @GetMapping("/comment/del/{id}")
    public Msg delComment(@PathVariable("id")  String id){
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
        return Result.success(map);
    }
    
    
}