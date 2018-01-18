package com.xmut.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;  
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xmut.pojo.ArticleInfo;
import com.xmut.service.ArticleService;
  
@Controller  
@RequestMapping("/admin")  
public class AdminController {  
	 
    @RequestMapping  
    public String index(ModelMap map){  
        map.put("title", "admin");  
        return "admin/main";  
    }  
    
    @RequestMapping("/test")
    public String test(ModelMap map){  
        map.put("title", "test");  
        return "admin/main2";  
    }  
    
    @RequestMapping("/createArticle")
    public String createArticle(ModelMap map){  
        map.put("title", "createArticle");  
        return "admin/createArticle";  
    } 
    
    
    @RequestMapping("/manageArticle")
    public String manageArticle(ModelMap map){  
        map.put("title", "manageArticle");  
        return "admin/manageArticle";  
    } 
    
    @RequestMapping("/editArticle/{id}")
    public String editArticle(@PathVariable("id")  String id,ModelMap map){
    	map.put("title", "editArticle");
    	map.put("articleId", id);
        return "admin/editArticle";  
    } 
    
    @RequestMapping("/manageComment")
    public String manageComment(ModelMap map){
    	map.put("title", "manageComment");
        return "admin/manageComment";  
    } 
}  