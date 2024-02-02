package org.example.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {
    private final List<String> messages = new ArrayList<>();

    public void addMessage(String text) {
        messages.add(text);
    }

    public List<String> getAllMessages() {
        return new ArrayList<>(messages);
    }
}
