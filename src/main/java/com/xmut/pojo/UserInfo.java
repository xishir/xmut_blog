package com.xmut.pojo;

import java.io.Serializable;


public class UserInfo implements Serializable{

    private static final long serialVersionUID = 1L;

    private String user_id;
    private String user_name;
    private String user_password;



    public UserInfo() {
    }


    public UserInfo(String user_id, String user_name, String user_password) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_password = user_password;
    }


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public String getUser_password() {
		return user_password;
	}


	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

    
}
