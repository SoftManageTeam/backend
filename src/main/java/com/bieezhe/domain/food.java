package com.bieezhe.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class food {

	@Id
	@GeneratedValue
	private int foodid;
	private int sellerid;
	private String foodname;
	private float foodprice;
	private String foodpicturedir;
	private String foodinfo;
	public int getFoodid() {
		return foodid;
	}
	public void setFoodid(int foodid) {
		this.foodid = foodid;
	}
	public int getSellerid() {
		return sellerid;
	}
	public void setSellerid(int sellerid) {
		this.sellerid = sellerid;
	}
	public String getFoodname() {
		return foodname;
	}
	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}
	public float getFoodprice() {
		return foodprice;
	}
	public void setFoodprice(float foodprice) {
		this.foodprice = foodprice;
	}
	public String getFoodpicturedir() {
		return foodpicturedir;
	}
	public void setFoodpicturedir(String foodpicturedir) {
		this.foodpicturedir = foodpicturedir;
	}
	public String getFoodinfo() {
		return foodinfo;
	}
	public void setFoodinfo(String foodinfo) {
		this.foodinfo = foodinfo;
	}
	
	
}
