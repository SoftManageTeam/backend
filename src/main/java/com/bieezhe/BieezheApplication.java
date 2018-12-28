package com.bieezhe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

/*
@SpringBootApplication
@ServletComponentScan
@EnableScheduling
@EnableCaching
public class BieezheApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BieezheApplication.class, args);
	}
	
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BieezheApplication.class);
    }
}*/

@SpringBootApplication
@ServletComponentScan
@EnableScheduling
@EnableCaching
public class BieezheApplication  {

	public static void main(String[] args) {
		SpringApplication.run(BieezheApplication.class, args);
	}
}

