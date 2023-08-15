package com.recipeai.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.recipeai.service.ChatRequest.Message;

import reactor.core.publisher.Mono;

@Service
public class ChatGPTService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ChatGPTService.class);


    private static final String USER = "user";
    private static final String MODEL = "gpt-3.5-turbo";
    private static final String API_URL = "https://api.openai.com/v1/chat/completions";

    private final RestTemplate openaiRestTemplate;

    @Autowired
    public ChatGPTService(@Qualifier("openaiRestTemplate") RestTemplate openaiRestTemplate) {
        this.openaiRestTemplate = openaiRestTemplate;
    }

    public Mono<ChatResponse> createChatCompletion(String prompt) {
        // create a request
        Message message = new Message(USER, prompt);
        ChatRequest request = new ChatRequest(MODEL, List.of(message));

        LOGGER.info("Request prompt: " + prompt);
        // call the API
        Mono<ChatResponse> result = Mono.just(openaiRestTemplate.postForObject(API_URL, request, ChatResponse.class));

        LOGGER.info("Result: " + result.toString());
        return result;
    }
}
