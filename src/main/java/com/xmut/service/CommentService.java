package com.xmut.service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.xmut.dao.ArticleMapper;
import com.xmut.dao.CommentMapper;
import com.xmut.pojo.CommentInfo;
import com.xmut.util.TimeUtil;
import com.xmut.util.XssUtil;

@Service
public class CommentService {
	@Autowired
	private CommentMapper commentmapper;
	@Autowired
	private ArticleMapper articleMapper;
	public void  createcomment(Map<String, Object> reqMap) {
		String article_id=reqMap.get("article_id").toString();
		String content=XssUtil.cleanXSS(reqMap.get("content").toString());
		String nickname=XssUtil.cleanXSS(reqMap.get("nickname").toString());
		reqMap.put("content", content);
		reqMap.put("nickname", nickname);
		articleMapper.addComment(article_id);
		reqMap.put("time",TimeUtil.getTime());
		commentmapper.createcomment(reqMap);
		
	}
	public ArrayList<CommentInfo> getComments(String article_id){
		return commentmapper.getComments(article_id);
	}
	
	public ArrayList<CommentInfo> getAllComments(String page){
		PageHelper.startPage(Integer.parseInt(page),10);
		return commentmapper.getAllComments();
	}

	public Integer getCommentNum()
    {
    	String num=commentmapper.getCommentNum();
    	return Integer.parseInt(num);
    }
	
	public Integer getPageNum()
    {
    	String num=commentmapper.getCommentNum();
    	return (Integer.parseInt(num)/10)+1;
    }
	
	public void addStar(String id) {
		commentmapper.addStar(id);
	}
	public void addDiss(String id) {
		commentmapper.addDiss(id);
	}
	public void deleteCommentById(String id) {
		commentmapper.deleteCommentById(id);
	}

}
