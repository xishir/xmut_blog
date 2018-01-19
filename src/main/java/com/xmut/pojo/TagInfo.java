package com.xmut.pojo;

import java.io.Serializable;

public class TagInfo implements Serializable{

	private static final long serialVersionUID = 1L;

    private String id;
    private String tag;
    private String num;
    
    public TagInfo() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	
	

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}
