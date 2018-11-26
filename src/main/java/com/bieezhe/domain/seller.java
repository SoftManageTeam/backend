package com.bieezhe.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class seller {

	@Id
	@GeneratedValue
	private int sellerid;
	
	private String sellername;
	private String sellertel;
	private String selleraddr;
	private String sellerpicturedir;
	private String selllerinfo;
	
	public seller(){
		
	}
	
	public int getSellerid() {
		return sellerid;
	}
	public void setSellerid(int sellerid) {
		this.sellerid = sellerid;
	}
	public String getSellername() {
		return sellername;
	}
	public void setSellername(String sellername) {
		this.sellername = sellername;
	}
	public String getSellertel() {
		return sellertel;
	}
	public void setSellertel(String sellertel) {
		this.sellertel = sellertel;
	}
	public String getSelleraddr() {
		return selleraddr;
	}
	public void setSelleraddr(String selleraddr) {
		this.selleraddr = selleraddr;
	}
	public String getSellerpicturedir() {
		return sellerpicturedir;
	}
	public void setSellerpicturedir(String sellerpicturedir) {
		this.sellerpicturedir = sellerpicturedir;
	}
	public String getSelllerinfo() {
		return selllerinfo;
	}
	public void setSelllerinfo(String selllerinfo) {
		this.selllerinfo = selllerinfo;
	}
	
	
}
