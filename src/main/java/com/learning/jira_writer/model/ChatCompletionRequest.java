package com.learning.jira_writer.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ChatCompletionRequest {

    private String model;
    private List<Message> messages;


    public ChatCompletionRequest(String model, String prompt) {
        this.model = model;
        this.messages = new ArrayList<Message>();
        this.messages.add(new Message("user", prompt));
    }
}
