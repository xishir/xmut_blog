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

public interface CommentMapper {

	@Insert("INSERT INTO blog.k_comment VALUES (#{article_id},#{nickname},#{content},#{time},#{star},#{diss})")
    void createcomment(Map<String, Object> reqMap);
	
	@Select("select * FROM blog.k_comment where article_id=#{article_id}")
    ArrayList<CommentInfo> getComments(@Param("article_id") String article_id);
	
	@Update("UPDATE blog.k_comment SET star = star+1 WHERE id = #{id}")
    void addStar(@Param("id") String id);
	
	@Update("UPDATE blog.k_comment SET diss = diss+1 WHERE id = #{id}")
    void addDiss( @Param("id") String id);
	
	@Delete("DELETE FROM blog.k_comment WHERE id = #{id}")
    void deleteCommentById(CommentInfo commentinfo);
}
