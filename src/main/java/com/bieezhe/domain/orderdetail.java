package com.bieezhe.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class orderdetail {

	@Id
	@GeneratedValue
	private Integer orderdetailid=-1;
	private Integer orderid=-1;
	
	@Column(columnDefinition = "varchar(1000)")
	private String foods;
	private int orderfoodcount;
	private float orderfoodpri;
	private String custname;
	private String time;

	
	public orderdetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public orderdetail(Integer orderid2, String string, int size, float totalPrice, String string2, String string3) {
		// TODO Auto-generated constructor stub
		orderid=orderid2;
		foods=string;
		orderfoodcount=size;
		orderfoodpri=totalPrice;
		custname=string2;
		time=string3;
	}
	
	public Integer getOrderdetailid(){
		return orderdetailid;
	}
	
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public int getOrderfoodcount() {
		return orderfoodcount;
	}
	public void setOrderfoodcount(int orderfoodcount) {
		this.orderfoodcount = orderfoodcount;
	}
	public float getOrderfoodpri() {
		return orderfoodpri;
	}
	public void setOrderfoodpri(float orderfoodpri) {
		this.orderfoodpri = orderfoodpri;  //
	}
	public String getFoods() {
		return foods;
	}
	public void setFoods(String foods) {
		this.foods = foods;
	}

	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}     
   
	
}
