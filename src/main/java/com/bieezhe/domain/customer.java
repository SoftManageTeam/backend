package com.bieezhe.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class customer {

	@Id
	@GeneratedValue
	private Integer custid;
	private String custname;
	private String custnickname;
	private String custpassword;
	private float custbalance;
	private String custtel;
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
	public String getCustnickname() {
		return custnickname;
	}
	public void setCustnickname(String custnickname) {
		this.custnickname = custnickname;
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
