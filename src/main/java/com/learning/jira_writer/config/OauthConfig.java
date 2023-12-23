package com.learning.jira_writer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

public class OauthConfig {

    @Value("open.ai.key")
    private String openaiApiKey;

    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(((request, body, execution) -> {
            request.getHeaders().add("Authorization", "Bearer " + openaiApiKey);
            return execution.execute(request, body);
        }));

        return restTemplate;
    }
}
