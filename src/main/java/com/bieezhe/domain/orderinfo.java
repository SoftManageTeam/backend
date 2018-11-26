package com.bieezhe.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class orderinfo {

	@Id
	@GeneratedValue
	private Integer orderid;
	private Integer custid;
	private Integer sellerid;
	private Integer exprid;
	private String orderprice;
	private Integer addruuid;
	private Date ordertime;
	private int orderstate;
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public Integer getCustid() {
		return custid;
	}
	public void setCustid(Integer custid) {
		this.custid = custid;
	}
	public Integer getSellerid() {
		return sellerid;
	}
	public void setSellerid(Integer sellerid) {
		this.sellerid = sellerid;
	}
	public Integer getExprid() {
		return exprid;
	}
	public void setExprid(Integer exprid) {
		this.exprid = exprid;
	}
	public String getOrderprice() {
		return orderprice;
	}
	public void setOrderprice(String orderprice) {
		this.orderprice = orderprice;
	}
	public Integer getAddruuid() {
		return addruuid;
	}
	public void setAddruuid(Integer addruuid) {
		this.addruuid = addruuid;
	}
	public Date getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}
	public int getOrderstate() {
		return orderstate;
	}
	public void setOrderstate(int orderstate) {
		this.orderstate = orderstate;
	}
	
	
}
