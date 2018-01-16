package com.xmut.pojo;

import java.io.Serializable;

public class CommentInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;

    private String id;
    private String article_id;
    private String nickname;
    private String content;
    private String time;
    private String star;
    private String diss;
    
    public CommentInfo() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getArticle_id() {
		return article_id;
	}

	public void setArticle_id(String article_id) {
		this.article_id = article_id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public String getDiss() {
		return diss;
	}

	public void setDiss(String diss) {
		this.diss = diss;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    

}
