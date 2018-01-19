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
import com.xmut.service.TagService;
import com.xmut.service.UserService;
import com.xmut.util.Msg;
import com.xmut.util.Result;

import io.swagger.annotations.Api;


@RequestMapping("/api/tag")
@RestController
@Api(value = "web", description = "tag")
public class TagController {

    @Autowired
    private TagService service;

    /**
     * 获取所有标签列表
     * @param page 页数
     * @return
     */
    @GetMapping("/list")
    public Msg getList(){
        return Result.success(service.getSort());
    }
    
}