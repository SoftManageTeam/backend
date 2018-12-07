package com.bieezhe.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class customer {

	@Id
	@GeneratedValue
	private Integer custid=-1;//默认值,应对添加用户是要检查custid值，实际值不是-1
	private String custname;
	private String custpassword;
	private float custbalance=200;
	private String custtel="0";
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getCustpassword() {
		return custpassword;
	}
	public void setCustpassword(String custpassword) {
		this.custpassword = custpassword;
	}
	public float getCustbalance() {
		return custbalance;
	}
	public void setCustbalance(float custbalance) {
		this.custbalance = custbalance;
	}
	public String getCusttel() {
		return custtel;
	}
	public void setCusttel(String custtel) {
		this.custtel = custtel;
	}
	
	
}
