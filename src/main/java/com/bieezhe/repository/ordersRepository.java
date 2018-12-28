package com.bieezhe.repository;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.bieezhe.domain.orders;

public interface ordersRepository extends JpaRepository<orders, Integer> {


	//@Query(value="select * from orders where custname=?1 and orderstate != 602",nativeQuery=true)
	ArrayList<orders> findAllByCustname(String Custname );

	@Modifying
	@Transactional
	@Query("update orders os set os.orderdetailid=?1 where os.orderid=?2")
	int setOrderdetailid(Integer orderdetailid, Integer integer);

	ArrayList<orders> findAllByExpressid(int expressid);

	@Modifying
	@Transactional
	@Query("update orders os set os.orderstate=?1 where os.orderid=?2")
	int setOrderstate(int i,int orderid) ;
	
	@Modifying
	@Transactional
	@Query("update orders os set os.orderstate=?1 where os.orderid=?2")
	int setOrderstate2(int i,int orderid) ;

	@Modifying
	@Transactional
	@Query("update orders os set os.expressid=?1 where os.orderid=?2")
	void setExpressid(Integer exprid, Integer orderid);


	orders findByOrderid(int orderid);

	@Query(value="SELECT COUNT(*) FROM orders where custname=?1 and orderstate != 601 ",nativeQuery=true)
	int getordernum(String name);

}

