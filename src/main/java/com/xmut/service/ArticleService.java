package com.xmut.service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmut.dao.ArticleMapper;
import com.xmut.pojo.ArticleInfo;

@Service
public class ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    public ArrayList<ArticleInfo> getList(Integer page) {
    	System.out.println("调用getArticles");
        return articleMapper.getArticles();
    }
    
    public ArticleInfo getInfo(String id) {
        return articleMapper.getArticle(id);
    }
    
    public String createArticle(Map<String, Object> reqMap)
    {
    	System.out.println("添加文章2");
    	articleMapper.createArticle(reqMap);
    	return "success";
    }
    
    
}