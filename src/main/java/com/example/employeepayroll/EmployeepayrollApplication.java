package com.example.employeepayroll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeepayrollApplication {
	private static final Logger log = LoggerFactory.getLogger(EmployeepayrollApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EmployeepayrollApplication.class, args);
		log.info("Application has Started");
	}
}
