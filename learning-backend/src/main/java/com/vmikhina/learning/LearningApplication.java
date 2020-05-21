package com.vmikhina.learning;

import com.vmikhina.learning.accessingdatamongodb.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.log4j.Logger;

@SpringBootApplication
public class LearningApplication {

	@Autowired
	private UsersRepository repository;

	private static final Logger LOG = Logger.getLogger(LearningApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LearningApplication.class, args);
		LOG.info("it works");
	}

}
