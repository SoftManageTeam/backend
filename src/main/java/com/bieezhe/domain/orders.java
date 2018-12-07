package com.bieezhe.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class orders {

	@Id
	@GeneratedValue
	private Integer orderid=-1;
	private Integer orderdetailid=-1;
	private String custname;
	private String address;
	private String phonenumber;
	private String sellername;
	private Integer expressid=-1;
	private float orderprice;
	private Integer orderstate=-1;
	private String time;

	
	public orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public orders(String username, String address2, String phone2, String shopName, float totalPrice, String string) {
		// TODO Auto-generated constructor stub
		custname=username;
		address=address2;
		setPhonenumber(phone2);
		sellername=shopName;
		orderprice=totalPrice;
		time=string;
	}

	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public Integer getOrderdetailid() {
		return orderdetailid;
	}

	public void setOrderdetailid(Integer orderdetailid) {
		this.orderdetailid = orderdetailid;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSellername() {
		return sellername;
	}

	public void setSellername(String sellername) {
		this.sellername = sellername;
	}

	public Integer getExpressid() {
		return expressid;
	}

	public void setExpressid(Integer expressid) {
		this.expressid = expressid;
	}

	public float getOrderprice() {
		return orderprice;
	}

	public void setOrderprice(float orderprice) {
		this.orderprice = orderprice;
	}

	public Integer getOrderstate() {
		return orderstate;
	}

	public void setOrderstate(Integer orderstate) {
		this.orderstate = orderstate;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
}
