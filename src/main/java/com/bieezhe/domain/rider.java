package com.bieezhe.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class rider {

	@Id
	@GeneratedValue
	private Integer exprid=-1;
	private String exprname;
	private String exprtel="-1";
	private float longitude=-1;
	private float latitude=-1;
	private String password;
	private int orderamount=0;
	public Integer getExprid() {
		return exprid;
	}
	public void setExprid(Integer exprid) {
		this.exprid = exprid;
	}
	public String getExprname() {
		return exprname;
	}
	public void setExprname(String exprname) {
		this.exprname = exprname;
	}
	public String getExprtel() {
		return exprtel;
	}
	public void setExprtel(String exprtel) {
		this.exprtel = exprtel;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getOrderamount() {
		return orderamount;
	}
	public void setOrderamount(int orderamount) {
		this.orderamount = orderamount;
	}
	@Override
	public String toString() {
		return "rider [exprid=" + exprid + ", exprname=" + exprname + ", exprtel=" + exprtel + ", longitude="
				+ longitude + ", latitude=" + latitude + ", password=" + password + ", orderamount=" + orderamount
				+ "]";
	}
	
}
