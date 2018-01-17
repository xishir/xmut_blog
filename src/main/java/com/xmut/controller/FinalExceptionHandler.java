package com.xmut.controller;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.xmut.util.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class FinalExceptionHandler implements ErrorController {
    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping(value = "/error")
    public Object error(HttpServletResponse resp, HttpServletRequest req) {
        // 错误处理逻辑
    	if(req.getHeader("Accept").indexOf("text/html")!=-1)
    	{
    		resp.setHeader("Location", "/");
    		resp.setStatus(302);
    		return Result.error(500, "服务器错误");
    	}
    	Integer code=resp.getStatus();
    	if(code==404)
    		return Result.error(code, "404 Not Found");
    	if(code==1024)
    		return Result.error(500, "请登陆");
    	if(code==200)
    		resp.setStatus(500);
    	return Result.error(code, "服务器错误");
    }
}

