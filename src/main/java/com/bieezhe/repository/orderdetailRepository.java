package com.bieezhe.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bieezhe.domain.orders;
import com.bieezhe.domain.orderdetail;

public interface orderdetailRepository extends JpaRepository<orderdetail, Integer> {

	//ArrayList<order> findAllByCustname(int custname);

}

