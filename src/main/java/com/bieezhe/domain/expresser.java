package com.bieezhe.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class expresser {

	@Id
	@GeneratedValue
	private Integer exprid;
	private String exprname;
	private String exprtel;
	private float longitude;
	private float latitude;
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
	
}
