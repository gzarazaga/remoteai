package com.recipeai.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.recipeai.service.ChatGPTService;
import com.recipeai.service.ChatResponse;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/recipeai")
public class RecipeAIController {

    @Autowired
    ChatGPTService recipeService;

    @GetMapping("/recipe")
    public Mono<ChatResponse> recipe(@RequestParam String prompt) {
        // return the first response
        return recipeService.createChatCompletion(prompt);
    }
}
