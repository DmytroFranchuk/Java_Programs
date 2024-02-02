package org.example.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

    private List<String> messages;

    public MessageService() {
        this.messages = new ArrayList<>();
    }

    public List<String> getMessages() {
        return new ArrayList<>(messages);
    }

    public void addMessages(String message) {
        messages.add(message);
    }
}
