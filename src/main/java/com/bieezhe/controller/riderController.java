package com.bieezhe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bieezhe.domain.orders;
import com.bieezhe.repository.ordersRepository;

@RestController
public class riderController {
	
	@Autowired
	private ordersRepository orderRespository;
	
	/**
	 * 返回所有商家
	 * @return
	 */
	@GetMapping(value="/rider")
	public List<orders> getOrders(){
		return orderRespository.findAll();
	}
	
}
