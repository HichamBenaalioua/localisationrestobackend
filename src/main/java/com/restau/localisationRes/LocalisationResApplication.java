package com.restau.localisationRes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins="*")
@SpringBootApplication
public class LocalisationResApplication {

	private static final Logger logger = LoggerFactory.getLogger(LocalisationResApplication.class);

	public static void main(String[] args) {
		
		SpringApplication.run(LocalisationResApplication.class, args);
		logger.info("App Started");
	}

}
