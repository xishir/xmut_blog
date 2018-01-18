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
import com.xmut.pojo.TagInfo;

@Mapper
public interface ArticleMapper {
	

	@Insert("INSERT INTO blog.k_article (title,author,sort,time,content) VALUES (#{title},#{author},#{sort},#{time},#{content})")
    void createArticle(Map<String, Object> reqMap);
	
	@Update("UPDATE blog.k_article SET visit = visit+1 WHERE id = #{id}")
    void addVisit(@Param("id") String id);
	
	@Update("UPDATE blog.k_article SET star = star+1 WHERE id = #{id}")
    void addStar( @Param("id") String id);
	
	@Update("UPDATE blog.k_article SET title = #{title} WHERE id = #{id}")
    void UpdataTitle(@Param("title") String title, @Param("id") String id);
	
	@Update("UPDATE blog.k_article SET author = #{author} WHERE id = #{id}")
    void UpdataAuthor(@Param("author") String author, @Param("id") String id);
	
	@Update("UPDATE blog.k_article SET content = #{content} WHERE id = #{id}")
    void UpdataContent(@Param("content") String content, @Param("id") String id);
	
	@Update("UPDATE blog.k_article SET title = #{title},author = #{author},sort = #{sort},time=#{time},content = #{content} WHERE id = #{id}")
    void UpdataArticle(Map<String, Object> reqMap);
	
	@Select("select * FROM blog.k_article WHERE id = #{id}")
	ArticleInfo getArticle(@Param("id") String id);
    
    @Select("select * FROM blog.k_article ")
    ArrayList<ArticleInfo> getArticles();
    
    @Select("select id from blog.k_article where id<#{id} order by id desc limit 1")
    String getFrontID(@Param("id") String id);
    
    @Select("select id from blog.k_article where id>#{id} order by id  limit 1")
    String getBehindID(@Param("id") String id);
    
    @Select("select * FROM blog.k_article order by time desc limit 10")
    ArrayList<ArticleInfo> getArticles_Hot();
    
    @Select("select distinct(sort) FROM blog.k_article ")
    ArrayList<TagInfo> getSort();
    
    @Select("select count(*) FROM blog.k_article ")
    String getPageNum();
    
    @Delete("DELETE FROM blog.k_article WHERE id = #{id}")
    void deleteArticleById(@Param("id") String id);
}
