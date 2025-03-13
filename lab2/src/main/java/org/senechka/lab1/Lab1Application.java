package org.senechka.lab1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class Lab1Application {

	private static final Logger logger = LoggerFactory.getLogger(Lab1Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Lab1Application.class, args);
		logger.info("Lab1 application started successfully.");
	}

}
