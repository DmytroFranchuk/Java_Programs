package org.example.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.PositiveOrZero;
import org.example.dto.User;
import org.example.dto.UserFormData;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;

@Controller
@RequestMapping(path = "/view")
public class ViewController {
    private final UserService userService;

    @Autowired
    public ViewController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile/{userId}")
    public String getProfileView(@PathVariable("userId") @PositiveOrZero long userId, Model model) {
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
        model.addAttribute("userForm", new UserFormData());
        return "user_registration";
    }

    @PostMapping("register")
    public String register(
            @ModelAttribute("userForm") @Valid UserFormData userForm,
            BindingResult result, // BindingResult должен идти после аргумента с @Valid
            Model model
    ) {
        if (result.hasErrors()) {
//            return "user_registration_error"; // ранее мы возвращали форму с сообщением об ошибке
            return "user_registration"; // теперь укажем ошибки в форме регистрации
        }
        User newUser = userService.createUser(userForm.toUser());
        model.addAttribute("userForm", userForm);
        model.addAttribute("newUser", newUser);
        return "user_registered";
    }

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("msg", "Welcome to the Netherlands!");
    }

    @GetMapping("/profile/{userId}/edit")
    public String getEditProfileForm(@PathVariable("userId") @PositiveOrZero long userId, Model model) {
        User user = userService.getUser(userId);
        UserFormData userFormData = new UserFormData();
        userFormData.setFirstName(user.firstName());
        userFormData.setLastName(user.lastName());
        userFormData.setBirthDate(user.birthDate());
        userFormData.setEmail(user.email());
        model.addAttribute("editForm", userFormData);
        model.addAttribute("userId", userId);
        return "user_profile_edit";
    }

    @PutMapping("/profile/{userId}/edit")
    public String editProfile(
            @PathVariable("userId") @PositiveOrZero long userId,
            @ModelAttribute("editForm") @Valid UserFormData editForm,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
//            return "user_profile_edit_error"; // ранее мы возвращали форму с сообщением об ошибке
            return "user_profile_edit"; // теперь укажем ошибки в форме изменения
        }
        User updatedUserDto = userService.updateUser(userId, editForm.toUser());
        model.addAttribute("updatedUser", updatedUserDto);
        return "user_profile_edit_success";
    }
}
