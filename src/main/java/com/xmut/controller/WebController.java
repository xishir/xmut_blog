package com.xmut.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;  
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;  
  
@Controller  
@RequestMapping("/")  
public class WebController {  
      
    @RequestMapping  
    public String index(ModelMap map){  
        map.put("title", "index");  
        return "index";  
    }  
    
    @RequestMapping("/login")
    public String log(ModelMap map){  
        map.put("title", "login");  
        return "admin/login";  
    }  
    
    @RequestMapping("/Archive/{id}")
    public String Archive(@PathVariable("id")  String id,ModelMap map){  
        map.put("title", "Archive");  
        map.put("ArchiveId",id);  
        return "Archive";  
    }  
    
      
}  