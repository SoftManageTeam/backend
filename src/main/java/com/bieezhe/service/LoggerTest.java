package com.bieezhe.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {
	
	private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);
	
	@Test
	public void test1(){
		String name="shadiao";
		String password="123456";
		logger.debug("debug...");
		logger.info("name: {},password: {}",name,password);
		logger.error("error...");

	}

}
