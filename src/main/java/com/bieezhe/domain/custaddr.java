package com.bieezhe.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class custaddr {

	@Id
	@GeneratedValue
	private Integer addruuid;
	private Integer custid;
	private String addr;
	public Integer getAddruuid() {
		return addruuid;
	}
	public void setAddruuid(Integer addruuid) {
		this.addruuid = addruuid;
	}
	public Integer getCustid() {
		return custid;
	}
	public void setCustid(Integer custid) {
		this.custid = custid;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
}
