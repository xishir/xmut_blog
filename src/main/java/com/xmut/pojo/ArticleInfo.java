package com.xmut.pojo;

import java.io.Serializable;

public class ArticleInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;

    private String id;
    private String title;
    private String author;
    private String sort;
    private String time;
    private String star;
    private String comment;
    private String visit;
    private String content;
    private String frontid;
    private String behindid;
    
    public String getFrontid() {
		return frontid;
	}
	public void setFrontid(String frontid) {
		this.frontid = frontid;
	}
	public String getBehindid() {
		return behindid;
	}
	public void setBehindid(String behindid) {
		this.behindid = behindid;
	}
	public ArticleInfo(){
    	
    }
    public ArticleInfo(String id,String title,String sort,String content) {
    	this.id=id;
    	this.title=title;
    	this.sort=sort;
    	this.content=content;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getStar() {
		return star;
	}

	public void setStar(String star) {
		this.star = star;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getVisit() {
		return visit;
	}

	public void setVisit(String visit) {
		this.visit = visit;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
	
}
