package com.xmut.controller;

import org.springframework.stereotype.Controller;  
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
  
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
}  