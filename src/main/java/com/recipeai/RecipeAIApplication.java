package com.recipeai;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RecipeAIApplication {
	
	@Value("${openai.api.key}")
    private String openaiApiKey;

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

    @Bean
    @Qualifier("openaiRestTemplate")
    public RestTemplate openaiRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add((request, body, execution) -> {
            request.getHeaders().add("Authorization", "Bearer " + openaiApiKey);
            return execution.execute(request, body);
        });
        return restTemplate;
    }
}
