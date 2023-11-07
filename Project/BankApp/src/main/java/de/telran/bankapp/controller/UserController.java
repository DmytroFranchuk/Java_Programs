package de.telran.bankapp.controller;

import de.telran.bankapp.entity.auth.User;
import de.telran.bankapp.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/user")
public class UserController {

    private final UserServiceImpl userService;

    @GetMapping(value = "/all")
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping(value = "/{id}")
    public UserDetails getByName(@PathVariable String id) {
        return userService.loadUserByUsername(id);
    }

    @PostMapping("/add")
    public User add(@RequestBody User user) {
        return userService.saveUser(user);
    }
}
