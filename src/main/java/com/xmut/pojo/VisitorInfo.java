package com.xmut.pojo;

import java.io.Serializable;

public class VisitorInfo implements Serializable{

	private static final long serialVersionUID = 1L;

    private String id;
    private String ip;
    private String time;
    private String web_ip;
    private String host;
    
    public VisitorInfo() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getWeb_ip() {
		return web_ip;
	}

	public void setWeb_ip(String web_ip) {
		this.web_ip = web_ip;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}
