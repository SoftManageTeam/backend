package com.bieezhe.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.bieezhe.domain.customer;

public interface customerRepository extends JpaRepository<customer, Integer> {

	customer findByCustname(String name);

	boolean existsByCustname(String name);

	@Modifying
	@Transactional
	@Query("update customer c set c.custbalance=?1 where c.custname=?2 ")
	int setCustbalance(float money, String username);

}

