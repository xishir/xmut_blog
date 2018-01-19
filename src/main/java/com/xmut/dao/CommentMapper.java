package com.xmut.dao;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.xmut.pojo.ArticleInfo;
import com.xmut.pojo.CommentInfo;
@Mapper
public interface CommentMapper {

	@Insert("INSERT INTO k_comment (article_id,nickname,content,time) VALUES (#{article_id},#{nickname},#{content},#{time})")
    void createcomment(Map<String, Object> reqMap);
	
	@Select("select * FROM k_comment where article_id=#{article_id} order by time desc")
    ArrayList<CommentInfo> getComments(@Param("article_id") String article_id);
	
	@Select("select comment.id,article_id,title,nickname,comment.content,comment.time,comment.star,diss FROM k_comment comment,k_article article where article_id=article.id order by time desc")
    ArrayList<CommentInfo> getAllComments();
	
	@Select("select count(*) FROM k_comment")
	String getCommentNum();
	
	@Update("UPDATE k_comment SET star = star+1 WHERE id = #{id}")
    void addStar(@Param("id") String id);
	
	@Update("UPDATE k_comment SET diss = diss+1 WHERE id = #{id}")
    void addDiss( @Param("id") String id);
	
	@Delete("DELETE FROM k_comment WHERE id = #{id}")
    void deleteCommentById(@Param("id") String id);
}
