package com.bieezhe.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.bieezhe.domain.customer;
import com.bieezhe.domain.food;
import com.bieezhe.domain.orderdetail;
import com.bieezhe.domain.orders;
import com.bieezhe.repository.customerRepository;
import com.bieezhe.repository.foodRepository;
import com.bieezhe.repository.ordersRepository;
import com.bieezhe.repository.orderdetailRepository;
import com.bieezhe.repository.sellerRepository;

@Service
public class IndexService {
	
	@Autowired
	private foodRepository foodRepository;
	
	@Autowired
	private sellerRepository sellerRepository;
	
	@Autowired
	private customerRepository customerRepository;
	
	@Autowired
	private orderdetailRepository orderdetailRepository;
	
	@Autowired
	private ordersRepository ordersRepository;

	public ArrayList<food> getFoodsById(int sellerid) throws Exception
	{
		if(!checkId("seller", sellerid)){
			throw new Exception("没有此商家！");
		}
		
		ArrayList<food> foods;
		foods = foodRepository.findAllBySellerid(sellerid);
		return foods;
	}
	
	public boolean checkId(String type,int id) throws Exception
	{
		boolean exist=false;
		if(type.equals("food")){
			exist = foodRepository.existsById(id);
		}
		else if(type.equals("seller")){
			exist = sellerRepository.existsById(id);
		}
		else if(type.equals("customer")){
			exist = customerRepository.existsById(id);
		}
		return exist;
	}

	public int login(String name, String password) {
		// TODO Auto-generated method stub
		boolean exist =customerRepository.existsByCustname(name);
		if(!exist)
			return 102;
		customer cust = null;
		cust = customerRepository.findByCustname(name);//如何返回某个字段的值
		if(cust.getCustpassword().equals(password)){
			return 100;
		}else{
			return 101;
		}
	}

	public int addOrder(JSONObject order) {
		// TODO Auto-generated method stub
		String username = order.getString("name");
	    String address = order.getString("address");
	    String phone = order.getString("phone");
	    String food = order.getString("food");
	    JSONObject _food = (JSONObject) JSONObject.parse(food);
	    System.out.println("food: "+food);
	    System.out.println("_food size: "+_food.size());
	    System.out.println("id1: "+_food.getString("1"));
	    
	    String shopName = order.getString("shopName");
	    float totalPrice = Float.parseFloat(order.getString("totalPrice"));
	    
	    
	    System.out.println("111");
		customer cust = null;
		cust = customerRepository.findByCustname(username);//如何返回某个字段的值
		System.out.println("id: "+cust.getCustid());
		System.out.println("222");
		if(cust.getCustbalance()>totalPrice){
			System.out.println("333");
			Date date = new Date();
		    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		    System.out.println(df.format(date));
		    orders odr = new orders(username,address,phone,shopName,totalPrice,df.format(date));
		    System.out.println("444");
		    //将订单存入数据库
		    orders newOdr = ordersRepository.save(odr);
		    System.out.println("555");
		    orderdetail orderdetail = new orderdetail(newOdr.getOrderid(),food.toString(),_food.size(),totalPrice,username,df.format(date));
		    System.out.println("666");
		    orderdetailRepository.save(orderdetail);
		    return 200;
		}else{
			return 201;
		}
	}

	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	public int addCustomer(JSONObject user) {
		// TODO Auto-generated method stub
	    String username = user.getString("name");
	    //检查用户名是否存在，用户名唯一标识
	    boolean exist =customerRepository.existsByCustname(username);
	    if(exist){
	    	return 301;
	    }
	    String password = user.getString("password");
	    customer cust = new customer();
	    System.out.println("custid: "+cust.getCustid());
	    cust.setCustname(username);
	    cust.setCustpassword(password);
	    customerRepository.save(cust);
		return 300;
	}
}
