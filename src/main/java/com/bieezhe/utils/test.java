package com.bieezhe.utils;

import java.util.Date;

import com.alibaba.fastjson.JSONObject;

public class test {
	
	private String userid;
	private String username;
	private String college;
	private String role;
	private int state;
	private Date regtime;
	private String userface;
	private String userpicturedir;
	private String iccard;
	

	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getCollege() {
		return college;
	}


	public void setCollege(String college) {
		this.college = college;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public int getState() {
		return state;
	}


	public void setState(int state) {
		this.state = state;
	}


	public Date getRegtime() {
		return regtime;
	}


	public void setRegtime(Date regtime) {
		this.regtime = regtime;
	}


	public String getUserface() {
		return userface;
	}


	public void setUserface(String userface) {
		this.userface = userface;
	}


	public String getUserpicturedir() {
		return userpicturedir;
	}


	public void setUserpicturedir(String userpicturedir) {
		this.userpicturedir = userpicturedir;
	}


	public String getIccard() {
		return iccard;
	}


	public void setIccard(String iccard) {
		this.iccard = iccard;
	}


	public static void main(String[] args) {
		String status = "101";
		String num = "000001";
		JSONObject data = new JSONObject();
		data.put("status", 101);
		data.put("num", 00001);
		System.out.println(data);
	}




}
