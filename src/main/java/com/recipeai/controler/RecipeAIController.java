package com.recipeai.controler;

import java.security.InvalidParameterException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recipeai.dto.RequestAIDTO;
import com.recipeai.service.ChatGPTService;
import com.recipeai.service.ChatResponse;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/recipeai")
public class RecipeAIController {

    @Autowired
    ChatGPTService recipeService;

    @GetMapping("/recipe")
    public Mono<ChatResponse> recipe(@RequestBody RequestAIDTO requestAiDTO) {
        validate(requestAiDTO);
        // return the first response
        return recipeService.createChatCompletion(requestAiDTO.getPrompt());
    }

    private void validate(RequestAIDTO requestAiDTO) {
        if (requestAiDTO.getPrompt() == null || requestAiDTO.getPrompt().isEmpty() || requestAiDTO.getPrompt().isBlank()) {
            throw new InvalidParameterException();
        }
    }
}
