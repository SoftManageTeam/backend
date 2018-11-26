package com.bieezhe.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bieezhe.domain.food;

public interface foodRepository extends JpaRepository<food, Integer> {

	ArrayList<food> findAllBySellerid(int sellerid);

}

