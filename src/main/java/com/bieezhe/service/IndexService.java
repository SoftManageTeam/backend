package com.bieezhe.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bieezhe.domain.food;
import com.bieezhe.repository.customerRepository;
import com.bieezhe.repository.foodRepository;
import com.bieezhe.repository.sellerRepository;

@Service
public class IndexService {
	
	@Autowired
	private foodRepository foodRepository;
	
	@Autowired
	private sellerRepository sellerRepository;
	
	@Autowired
	private customerRepository customerRepository;

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
}
