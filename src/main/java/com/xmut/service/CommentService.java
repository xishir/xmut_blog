package com.xmut.service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmut.dao.ArticleMapper;
import com.xmut.dao.CommentMapper;
import com.xmut.pojo.CommentInfo;
import com.xmut.util.TimeUtil;

@Service
public class CommentService {
	@Autowired
	private CommentMapper commentmapper;
	@Autowired
	private ArticleMapper articleMapper;
	public void  createcomment(Map<String, Object> reqMap) {
		String article_id=reqMap.get("article_id").toString();
		articleMapper.addComment(article_id);
		reqMap.put("time",TimeUtil.getTime());
		commentmapper.createcomment(reqMap);
		
	}
	public ArrayList<CommentInfo> getComments(String article_id){
		System.out.println("获取评论");
		return commentmapper.getComments(article_id);
		
	}
	public void addStar(String id) {
		commentmapper.addStar(id);
	}
	public void addDiss(String id) {
		commentmapper.addDiss(id);
	}
	public void deleteCommentById(CommentInfo commentinfo) {
		commentmapper.deleteCommentById(commentinfo);
	}

}
