package com.bieezhe.utils;

import com.alibaba.fastjson.JSONObject;

public class test {
	public static void main(String[] args) {
		String status = "101";
		String num = "000001";
		JSONObject data = new JSONObject();
		data.put("status", 101);
		data.put("num", 00001);
		System.out.println(data);
	}
}
