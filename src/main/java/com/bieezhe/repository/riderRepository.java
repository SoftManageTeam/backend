package com.bieezhe.repository;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.bieezhe.domain.orders;
import com.bieezhe.domain.rider;

public interface riderRepository extends JpaRepository<rider, Integer> {

	boolean existsByExprname(String exprname) ;

	rider findByExprname(String exprname);

    ArrayList<orders> findAllByExprname(String ridername);

	@Modifying
	@Transactional
	@Query("update rider rd set rd.orderamount=?1 where rd.exprid=?2")
	void setOrderamount(int orderamount, Integer exprid);

	rider findByExprid(int expressid);
	
}

