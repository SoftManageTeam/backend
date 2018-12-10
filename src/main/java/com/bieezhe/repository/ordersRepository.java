package com.bieezhe.repository;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.bieezhe.domain.orders;

public interface ordersRepository extends JpaRepository<orders, Integer> {

	ArrayList<orders> findAllByCustname(String Custname );

	@Modifying
	@Transactional
	@Query("update orders os set os.orderdetailid=?1")
	int setOrderdetailid(Integer orderdetailid);

}

