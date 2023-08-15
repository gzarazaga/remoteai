package com.recipeai.service;

import org.junit.jupiter.api.Test;
import org.mockito.exceptions.base.MockitoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
@ActiveProfiles("test")
public class ChatGPTServiceTest {

    @Autowired
    private ChatGPTService chatGPTService;

    //@Test
    void createChatCompletionTest() throws MockitoException {

        Mono<ChatResponse> responseMono = chatGPTService.createChatCompletion("Podrías traducirme la frase 'Cómo mejorar la documentación de tu proyecto IT' al inglés?");
        
        StepVerifier.create(responseMono)
            .expectNextMatches(response -> {System.out.println(response); return true;})
            .verifyComplete();
    }
}