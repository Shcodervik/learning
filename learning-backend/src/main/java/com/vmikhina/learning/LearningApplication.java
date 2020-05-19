package com.vmikhina.learning;

import com.vmikhina.learning.accessingdatamongodb.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearningApplication {

	@Autowired
	private UsersRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(LearningApplication.class, args);
	}

}
