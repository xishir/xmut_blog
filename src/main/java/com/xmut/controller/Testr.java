package com.xmut.controller;  
    
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;  
  
@RequestMapping("/round2")  
@RestController  
public class Testr {  
      
    @RequestMapping(method = RequestMethod.GET)  
    public String round2() {  
        return "Hello World2!";  
    }  
}  