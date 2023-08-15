package com.recipeai.dto;

public class RequestAIDTO {
    private String prompt;

    public RequestAIDTO() {
    }

    public RequestAIDTO(String prompt) {
        this.prompt = prompt;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }


}
