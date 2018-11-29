package com.bieezhe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bieezhe.domain.customer;
import com.bieezhe.domain.food;
import com.bieezhe.domain.orderinfo;
import com.bieezhe.domain.seller;
import com.bieezhe.repository.customerRepository;
import com.bieezhe.repository.foodRepository;
import com.bieezhe.repository.orderinfoRepository;
import com.bieezhe.repository.sellerRepository;
import com.bieezhe.service.IndexService;

@RestController
public class indexController {

	@Autowired
	private sellerRepository sellerRepository;
	
	@Autowired
	private customerRepository customerRepository;
	
	@Autowired
	private foodRepository foodRepository;
	
	@Autowired 
	private IndexService indexService;
	
	@Autowired
	private orderinfoRepository orderinfoRespository;
	
	/**
	 * 返回所有商家
	 * @return
	 */
	@GetMapping(value="/index")
	public List<seller> getShops(){
		return sellerRepository.findAll();
	}
	
	/**
	 * 添加一个用户
	 * @param cus
	 * @return
	 */
	@PostMapping(value="/login/signup")
	public Object addCustomer(customer cus){
		return customerRepository.save(cus);
	}
	
	/**
	 * 根据商家id返回该商家所有菜品
	 * @param sellerid
	 * @return
	 */
	@GetMapping(value="/index/sellerid/{sellerid}")
	public ArrayList<food> showFoodsById(@PathVariable("sellerid") int sellerid) throws Exception
	{
		ArrayList<food> foods=null;
		try {
			foods=indexService.getFoodsById(sellerid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return foods;
	}
	 
	/**
	 * 接受订单信息
	 * @param odo
	 * @return
	 */   
	@PostMapping(value="/index/sellerid/order")
	public Object addOrder(orderinfo odo){
		return orderinfoRespository.save(odo); 
	}
	
	
	/*
	@GetMapping(value="")
	public List<seller> getShops(@RequestParam("position") String position){
		
		return shopList;
	}*/
}
