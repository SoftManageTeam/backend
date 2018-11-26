package com.bieezhe.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class orderfood {

	@Id
	@GeneratedValue
	private Integer orderfoodid;
	private Integer orderid;
	private Integer foodid;
	private int orderfoodcount;
	private float orderfoodpri;
	
	public Integer getOrderfoodid() {
		return orderfoodid;
	}
	public void setOrderfoodid(Integer orderfoodid) {
		this.orderfoodid = orderfoodid;
	}
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public Integer getFoodid() {
		return foodid;
	}
	public void setFoodid(Integer foodid) {
		this.foodid = foodid;
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
		this.orderfoodpri = orderfoodpri;
	}
	public int getOrderstate() {
		return orderstate;
	}
	public void setOrderstate(int orderstate) {
		this.orderstate = orderstate;
	}
	
	
}
