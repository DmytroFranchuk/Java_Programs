package org.example.controller;

import org.example.dto.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
    private final UserSession userSession;
    @Autowired
    public WelcomeController(UserSession userSession) {
        this.userSession = userSession;
    }

    @GetMapping("/welcome")
    public String welcome(Model model) {
        if (userSession.isNewUser()) {
            model.addAttribute("message", "Welcome, new user!");
            userSession.setNewUser(false);
        } else {
            model.addAttribute("message", "Welcome back!");
        }
        userSession.incrementVisitCount();
        if (userSession.getVisitCount() >= 5) {
            userSession.resetVisitCount();
            userSession.setNewUser(true);
        }
        model.addAttribute("userSession", userSession);
        return "welcome_user";
    }
























}
