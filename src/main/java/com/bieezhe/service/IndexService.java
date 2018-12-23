package com.bieezhe.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.bieezhe.domain.customer;
import com.bieezhe.domain.food;
import com.bieezhe.domain.orderdetail;
import com.bieezhe.domain.orders;
import com.bieezhe.domain.rider;
import com.bieezhe.domain.seller;
import com.bieezhe.repository.customerRepository;
import com.bieezhe.repository.foodRepository;
import com.bieezhe.repository.orderdetailRepository;
import com.bieezhe.repository.ordersRepository;
import com.bieezhe.repository.riderRepository;
import com.bieezhe.repository.sellerRepository;

import com.bieezhe.utils.PieceAlgorithm;

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

	@Autowired
	private riderRepository riderRepository;
	
	@Autowired
	private PieceAlgorithm PieceAlgorithm;
	
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

	public JSONObject addOrder(JSONObject order) {
		// TODO Auto-generated method stub
		String username = order.getString("name");
	    String address = order.getString("address");
	    String phone = order.getString("phone");
	    String food = order.getString("food");
	    JSONObject _food = (JSONObject) JSONObject.parse(food);

	    String shopName = order.getString("shopName");
	    float totalPrice = Float.parseFloat(order.getString("totalPrice"));
	    
		customer cust = null;
		cust = customerRepository.findByCustname(username);//如何返回某个字段的值
		if(cust.getCustbalance()>totalPrice){
			Date date = new Date();
		    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		    orders odr = new orders(username,address,phone,shopName,totalPrice,df.format(date));
		    
		    //将订单存入数据库
		    orders newOdr = ordersRepository.save(odr);
		    orderdetail orderdetail = new orderdetail(newOdr.getOrderid(),food.toString(),_food.size(),totalPrice,username,df.format(date));
		    
		    //更新用户余额
		    customerRepository.setCustbalance(cust.getCustbalance()-totalPrice,username);
		    
		    //将详细订单存入数据库
		    orderdetail od = orderdetailRepository.save(orderdetail);
		
		    //更新orders中的信息
		    ordersRepository.setOrderdetailid(od.getOrderdetailid(),newOdr.getOrderid());
		    JSONObject data = new JSONObject();
		    data.put("statusCode",200);
		    data.put("orderid",odr.getOrderid());
		    
		    //调用派单算法
		    seller sr = sellerRepository.findBySellername(shopName);
		    List<rider> alrd =  riderRepository.findAll();
		    LinkedList<rider> llrd = new LinkedList<rider>();
		    for (rider rd : alrd){
		    	llrd.add(rd);
		    }
		    rider rd = PieceAlgorithm.PieceAlgorthm(sr,llrd);
		    
		    //修改rider信息
		    riderRepository.setOrderamount(rd.getOrderamount()+1,rd.getExprid());
		    
		    
		    //修改订单信息
		    ordersRepository.setExpressid(rd.getExprid(),newOdr.getOrderid());
		    
		    return data;
		}else{
			JSONObject data = new JSONObject();
		    data.put("statusCode",201);
		    data.put("orderid",-1);
			return data;
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
	    cust.setCustname(username);
	    cust.setCustpassword(password);
	    customerRepository.save(cust);
		return 300;
	}
}
