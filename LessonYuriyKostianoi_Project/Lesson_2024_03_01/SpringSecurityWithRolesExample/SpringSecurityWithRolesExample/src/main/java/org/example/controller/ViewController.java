package org.example.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.PositiveOrZero;
import org.example.dto.user.UserResponseDto;
import org.example.dto.user.UserFormData;
import org.example.entity.user.credentials.UserWithCredentials;
import org.example.mapper.UserMapper;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    private final UserMapper userMapper;


    @Autowired
    public ViewController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/index")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/profile")
    public String getProfileView(Model model) {
        UserWithCredentials details = getUserDetails();
        model.addAttribute("login", details.getUsername());

        model.addAttribute("id", details.getUser().getId());
        model.addAttribute("firstName", details.getUser().getFirstName());
        model.addAttribute("lastName", details.getUser().getLastName());
        model.addAttribute(
                "age",
                details.getUser().getBirthDate() == null ?
                        "" :
                        Period.between(details.getUser().getBirthDate(), LocalDate.now()).getYears()
        );



        model.addAttribute("email", details.getUser().getEmail() != null ? details.getUser().getEmail() : "");
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
        UserResponseDto newUserResponseDto = userService.createUser(userMapper.toUserCreateRequestDto(userForm));
        model.addAttribute("userForm", userForm);
        model.addAttribute("newUser", newUserResponseDto);
        return "user_registered";
    }

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("msg", "Welcome to the Netherlands!");
    }

    @GetMapping("/profile/edit")
    public String getEditProfileForm(Model model) {
        UserWithCredentials details = getUserDetails();
        UserFormData userFormData = new UserFormData();
        userFormData.setFirstName(details.getUser().getFirstName());
        userFormData.setLastName(details.getUser().getLastName());
        userFormData.setBirthDate(details.getUser().getBirthDate());
        userFormData.setEmail(details.getUser().getEmail());
        model.addAttribute("editForm", userFormData);
        model.addAttribute("userId", details.getUser().getId());
        return "user_profile_edit";
    }

    @PutMapping("/profile/edit")
    public String editProfile(
            @ModelAttribute("editForm") @Valid UserFormData editForm,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            return "user_profile_edit";
        }
        UserWithCredentials details = getUserDetails();
        UserResponseDto updatedUserDtoResponseDto = userService.updateUser(
                details.getUser().getId(),
                userMapper.toUserCreateRequestDto(editForm)
        );
        model.addAttribute("updatedUser", updatedUserDtoResponseDto);
        return "user_profile_edit_success";
    }

    private UserWithCredentials getUserDetails(){
        // Обращение к контексту безопасности
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); // получим бин текущего потока, т.е. пользователя
        return (UserWithCredentials)authentication.getPrincipal();
    }
}
