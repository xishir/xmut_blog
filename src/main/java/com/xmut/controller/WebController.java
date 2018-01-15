package com.xmut.controller;

import org.springframework.stereotype.Controller;  
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;  
  
@Controller  
@RequestMapping("/")  
public class WebController {  
      
    @RequestMapping  
    public String index(ModelMap map){  
        map.put("title", "HelloWorld");  
        return "index";  
    }  
    
    @RequestMapping("/blog")
    public String blog(ModelMap map){  
        map.put("title", "HelloWorld");  
        return "blog";  
    }  
      
}  