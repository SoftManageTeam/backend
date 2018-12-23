package com.bieezhe.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.bieezhe.domain.customer;
import com.bieezhe.domain.orders;
import com.bieezhe.domain.rider;
import com.bieezhe.repository.ordersRepository;
import com.bieezhe.repository.riderRepository;
import com.bieezhe.repository.sellerRepository;

@Service
public class RiderService {
	
	@Autowired
	private riderRepository riderRepository;
	
	@Autowired
	private ordersRepository ordersRepository;
	
	public  int addRider(JSONObject rider) {
		// TODO Auto-generated method stub
		
		String username = rider.getString("name");
	    //检查用户名是否存在，用户名唯一标识
	    boolean exist =riderRepository.existsByExprname(username);
	    if(exist){
	    	return 311;
	    }
	    String password = rider.getString("password");
	    rider rd = new rider();
	    rd.setExprname(username);
	    rd.setPassword(password);
	    System.out.println(rd.toString());
	    riderRepository.save(rd);
		return 310;
	}

	public JSONObject login(JSONObject rider) {
		// TODO Auto-generated method stub
		JSONObject result = new JSONObject();
		String username = rider.getString("name"); 
		boolean exist = riderRepository.existsByExprname(username);
		if(!exist){
			result.put("statusCode", 112);
			result.put("name", "");
			return result;
		}
		String _password = rider.getString("password");
		rider rd = riderRepository.findByExprname(username);
		if(rd.getPassword().equals(_password))
		{
			result.put("statusCode", 110);
			result.put("name", rd.getExprname());
			return result;
		}else{
			result.put("statusCode", 111);
			result.put("name", "");
			return result;
		}
	}

	public int finishorder(JSONObject data) {
		// TODO Auto-generated method stub
		int orderid = Integer.parseInt(data.getString("orderid")); 
		int result = ordersRepository.setOrderstate(601,orderid);
		orders od = ordersRepository.findByOrderid(orderid);
		rider rider = riderRepository.findByExprid(od.getExpressid());
		riderRepository.setOrderamount(rider.getOrderamount()-1,od.getExpressid());
		if(result==0)
		{
			return 501;
		}
		else{
			return 500;
		}
	}

	public ArrayList<orders> showOrdersById(JSONObject data) {
		// TODO Auto-generated method stub
		ArrayList<orders> orders = new ArrayList<orders>();
		String Ridername = data.getString("name");
		rider rd = riderRepository.findByExprname(Ridername);
		System.out.println("Ridername: "+rd.getExprid());
		int expressid=rd.getExprid();
		try {
			orders = ordersRepository.findAllByExpressid(expressid);
			//System.out.println("\n\norders: \n\n"+orders);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orders;
	}

	
}
