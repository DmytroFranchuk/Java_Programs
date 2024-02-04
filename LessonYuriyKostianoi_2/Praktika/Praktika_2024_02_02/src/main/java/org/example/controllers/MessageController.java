package org.example.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/messages")
public class MessageController {
    private MessageService messageService;
    private ObjectMapper mapper;

    @Autowired
    public MessageController(MessageService messageService, ObjectMapper mapper) {
        this.messageService = messageService;
        this.mapper = mapper;
    }

    @GetMapping("/messages")
    @ResponseBody
    public String getMessages() {
        try {
            return mapper.writeValueAsString(messageService.getMessage());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/messages")
    public String postMessages(@RequestBody String message) {
        if (message == null || message.isEmpty()) {
            return "error";
        }
        messageService.putMessage(message);
        return "accepted";
    }

}
