package com.vmikhina.learning;

import com.vmikhina.learning.accessingdatamongodb.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class LearningApplication {

	@Autowired
	private UsersRepository repository;

	private static final Logger LOG = Logger.getLogger(LearningApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LearningApplication.class, args);
		LOG.info("it works");
	}

  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/login").allowedOrigins("http://localhost:4200");
      }
    };
  }

}
