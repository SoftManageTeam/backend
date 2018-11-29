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
public class riderController {
	
	@Autowired
	private orderinfoRepository orderinfoRespository;
	
	/**
	 * 返回所有商家
	 * @return
	 */
	@GetMapping(value="/rider")
	public List<orderinfo> getOrders(){
		return orderinfoRespository.findAll();
	}
	
}
