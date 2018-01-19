package com.xmut.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.xmut.util.Msg;
import com.xmut.util.Result;

/**
 * Created by wuwf on 17/3/31.
 * 全局异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    private static final HttpStatus NOT_EXTENDED = null;

	//    @ExceptionHandler(value = Exception.class)
//    public ModelAndView defaultHandler(HttpServletRequest request, Exception e) throws Exception {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("exception", e);
//        modelAndView.addObject("url", request.getRequestURL());
//        modelAndView.setViewName("error");
//        return modelAndView;
//    }

    /**
     * 在controller里面内容执行之前，校验一些参数不匹配啊，Get post方法不对啊之类的
     */
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        System.out.println("错误");
        return new ResponseEntity<Object>("出错了", NOT_EXTENDED);

    }
    
    
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Msg jsonHandler(HttpServletRequest request, Exception e) throws Exception {
        return Result.error(500, "服务器错误");
    }
}