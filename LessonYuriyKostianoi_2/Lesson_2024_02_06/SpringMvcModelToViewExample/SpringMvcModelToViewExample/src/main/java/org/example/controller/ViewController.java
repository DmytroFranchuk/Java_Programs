package org.example.controller;

import org.example.dto.User;
import org.example.dto.UserFormData;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping(path = "/view")
public class ViewController {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final UserService userService;

    @Autowired
    public ViewController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile/{userId}")
    public String getProfileView(@PathVariable("userId") long userId, Model model) {
        User user = userService.getUser(userId);
        model.addAttribute("id", user.id());
        model.addAttribute("firstName", user.firstName());
        model.addAttribute("lastName", user.lastName());
        model.addAttribute(
                "age",
                user.birthDate() == null ? "" : Period.between(user.birthDate(), LocalDate.now()).getYears()
        );
        model.addAttribute("email", user.email() != null ? user.email() : "");
        return "user_profile";
    }

    @GetMapping("register")
    public String getRegisterForm(Model model) {
        model.addAttribute("userForm", new UserFormData()); // подготавливаем болванку для заполнения объекта данными формы
        return "user_registration";
    }

    // Аннотация @ModelAttribute говорит Spring внедрить бин с указанным именем из атрибутов модели
    @PostMapping("register")
    public String register(@ModelAttribute("userForm") UserFormData userForm, BindingResult result, Model model) {
        if (result.hasErrors()) { // проверка, что при переносе данных из запроса в бин userForm не возникло ошибок
            return "user_registration_error";
        }
        User newUser = userService.createUser(userForm.toUser());
        model.addAttribute("userForm", userForm);
        model.addAttribute("newUser", newUser);
        return "user_registered";
    }

    @ModelAttribute // Показывает, что метод подготавливает атрибуты модели. Выполняется до начала работы контроллера
    public void addAttributes(Model model) {
        model.addAttribute("msg", "Welcome to the Netherlands!");
    }
}
