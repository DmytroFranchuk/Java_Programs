package org.example.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.PositiveOrZero;
import org.example.dto.UserDto;
import org.example.dto.UserFormData;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
        UserDto userDto = userService.getUser(userId);
        model.addAttribute("id", userDto.id());
        model.addAttribute("firstName", userDto.firstName());
        model.addAttribute("lastName", userDto.lastName());
        model.addAttribute(
                "age",
                userDto.birthDate() == null ? "" : Period.between(userDto.birthDate(), LocalDate.now()).getYears()
        );
        model.addAttribute("email", userDto.email() != null ? userDto.email() : "");
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
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            return "user_registration";
        }
        UserDto newUserDto = userService.createUser(userForm.toUser());
        model.addAttribute("userForm", userForm);
        model.addAttribute("newUser", newUserDto);
        return "user_registered";
    }

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("msg", "Welcome to the Netherlands!");
    }

    @GetMapping("/profile/{userId}/edit")
    public String getEditProfileForm(@PathVariable("userId") @PositiveOrZero long userId, Model model) {
        UserDto userDto = userService.getUser(userId);
        UserFormData userFormData = new UserFormData();
        userFormData.setFirstName(userDto.firstName());
        userFormData.setLastName(userDto.lastName());
        userFormData.setBirthDate(userDto.birthDate());
        userFormData.setEmail(userDto.email());
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
            return "user_profile_edit";
        }
        UserDto updatedUserDtoDto = userService.updateUser(userId, editForm.toUser());
        model.addAttribute("updatedUser", updatedUserDtoDto);
        return "user_profile_edit_success";
    }
}
