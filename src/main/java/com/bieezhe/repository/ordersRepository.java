package com.bieezhe.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bieezhe.domain.orders;

public interface ordersRepository extends JpaRepository<orders, Integer> {

	ArrayList<orders> findAllByCustname(String Custname );

}

