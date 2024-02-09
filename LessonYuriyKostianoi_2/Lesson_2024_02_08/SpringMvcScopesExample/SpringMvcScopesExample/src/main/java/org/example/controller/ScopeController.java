package org.example.controller;

import jakarta.servlet.http.HttpSession;
import org.example.message.MessageGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/scope")
public class ScopeController {

    private final MessageGenerator sessionMessageGenerator;
    private final MessageGenerator requestMessageGenerator; // Как бин, который пересоздаётся при каждом запросе, может быть в поле final?

    @Autowired
    public ScopeController(
            @Qualifier("sessionMessageGenerator") MessageGenerator sessionMessageGenerator,
            @Qualifier("requestMessageGenerator") MessageGenerator requestMessageGenerator
    ) {
        this.sessionMessageGenerator = sessionMessageGenerator;
        this.requestMessageGenerator = requestMessageGenerator;
    }

    @GetMapping("/request")
    public String getRequestMessage(Model model) {
        model.addAttribute("message", requestMessageGenerator.nextMessage().orElse(""));
        return "message";
    }

    @GetMapping("/session")
    public String getSessionMessage(
            Model model,
            HttpSession session
    ) {
        model.addAttribute("message", sessionMessageGenerator.nextMessage().orElse(""));
        System.out.println("Осталось " + sessionMessageGenerator.remainingMessages());
        System.out.println(session.getId());
        if (sessionMessageGenerator.remainingMessages() <= 0) session.invalidate(); // сброс сессии
        return "message";
    }

}
