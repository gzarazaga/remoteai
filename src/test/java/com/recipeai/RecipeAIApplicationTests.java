package com.recipeai;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.recipeai.config.H2TestProfileJPAConfig;

@SpringBootTest(classes = {RecipeAIApplication.class, H2TestProfileJPAConfig.class})
@ActiveProfiles("test")
class RecipeAIApplicationTests {

	@Test
	void contextLoads() {
	}

}

