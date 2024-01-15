package com.learning.jira_writer.controller;

import com.learning.jira_writer.client.OpenaiClient;
import com.learning.jira_writer.model.ChatCompletionRequest;
import com.learning.jira_writer.model.ChatCompletionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
public class ChatController {

    private RestClient restClient;

    @Value("open.ai.model")
    String openAiModel;

    @Autowired
    private OpenaiClient openaiClient;

    @PostMapping("/get/openAiResponse")
    public String getOpenaiResponse(@RequestBody String prompt) {
        ChatCompletionRequest chatCompletionRequest = new ChatCompletionRequest("gpt-3.5-turbo", prompt);
        ChatCompletionResponse chatCompletionResponse = openaiClient.callOpenaiClient(chatCompletionRequest);
        System.out.println(chatCompletionResponse);
        return chatCompletionResponse.getChoices().get(0).getMessage().getContent() ;
    }
}
