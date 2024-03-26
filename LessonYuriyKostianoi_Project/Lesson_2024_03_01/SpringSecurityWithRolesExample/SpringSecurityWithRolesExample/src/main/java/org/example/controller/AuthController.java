package org.example.controller;

import org.example.dto.auth.UserRegistrationFormData;
import org.example.dto.user.UserResponseDto;
import org.example.service.UserService;
import org.example.util.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "auth")
public class AuthController {
    private final UserValidator userValidator;
    private final UserService userService;

    @Autowired
    public AuthController(UserValidator userValidator, UserService userService) {
        this.userValidator = userValidator;
        this.userService = userService;
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "auth/login";
    }

    @GetMapping("/registration")
    public String getRegistrationPage(@ModelAttribute("registrationForm") UserRegistrationFormData userFormData) {
        return "auth/registration";
    }

    @PostMapping("/registration")
    public String completeRegistration(
            @ModelAttribute("registrationForm") UserRegistrationFormData userFormData,
            BindingResult result
    ) {
        userValidator.validate(userFormData, result);
        if (result.hasErrors()) return "auth/registration";
        userService.createUser(userFormData);
        return "redirect:/login";
    }
}
