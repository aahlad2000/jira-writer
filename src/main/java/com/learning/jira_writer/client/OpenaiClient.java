package com.learning.jira_writer.client;

import com.learning.jira_writer.model.ChatCompletionRequest;
import com.learning.jira_writer.model.ChatCompletionResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class OpenaiClient {

    @Value("open.ai.key")
    String openAiSecret;

    private RestClient restClient = RestClient.builder().defaultHeader("Authorization", "Bearer " + "").baseUrl("https://api.openai.com").build();

    public ChatCompletionResponse callOpenaiClient(ChatCompletionRequest chatCompletionRequest){
        System.out.println(chatCompletionRequest);
        return restClient
                .post()
                .uri("/v1/chat/completions")
                .contentType(MediaType.APPLICATION_JSON)
                .body(chatCompletionRequest)
                .retrieve()
                .toEntity(ChatCompletionResponse.class).getBody();
    }
}
