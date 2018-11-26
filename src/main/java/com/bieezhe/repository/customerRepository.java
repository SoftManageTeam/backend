package com.bieezhe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bieezhe.domain.customer;

public interface customerRepository extends JpaRepository<customer, Integer> {

}

