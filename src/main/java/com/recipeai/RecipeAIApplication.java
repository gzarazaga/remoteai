package com.recipeai;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.recipeai")
public class RecipeAIApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(RecipeAIApplication.class);
	
	public static void main(String[] args) {
		try {
			SpringApplication.run(RecipeAIApplication.class, args);
			LOGGER.info("Simple log statement with inputs {}, {} and {}", 1,2,3);
		}  catch (Exception e) {
			LOGGER.error("Error starting application {}", e);
			throw e;
		}
	}
 
}
