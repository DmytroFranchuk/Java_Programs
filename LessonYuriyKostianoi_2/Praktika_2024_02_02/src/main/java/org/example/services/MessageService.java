package org.example.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {
    private List<String> message;

    public MessageService() {
        message = new ArrayList<>();
    }

    public List<String> getMessage() {
        return new ArrayList<>(message);
    }

    public void putMessage(String str) {
        this.message.add(str);
    }

}
