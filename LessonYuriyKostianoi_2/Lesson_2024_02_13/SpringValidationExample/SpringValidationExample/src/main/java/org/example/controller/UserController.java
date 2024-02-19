package org.example.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PositiveOrZero;
import org.example.dto.User;
import org.example.service.StatisticsService;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated // Показывает, что нужно проверять входные аргументы методов контроллера
@RestController
public class UserController {
    private final UserService userService;
    private final StatisticsService statisticsService;

    @Autowired
    public UserController(UserService userService, StatisticsService statisticsService) {
        this.userService = userService;
        this.statisticsService = statisticsService;
    }

    @GetMapping("/users")
    public List<User> getUsers(
            @RequestParam(value = "lastNameStartsWith", required = false, defaultValue = "") String lastNameStartsWith
    ) {
        return userService.getUsers(lastNameStartsWith);
    }

    // Аннотация @PositiveOrZero ограничивает допустимые значения id значениями >= 0
    @GetMapping("/users/{id}")
    public User getUser(@PathVariable("id") @Min(0) long id) {
        return userService.getUser(id);
    }

    @PostMapping(path ="/users",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public User createUser(
            @RequestBody @Valid User candidate, // аннотация @Valid говорит, что нужно передать объект на анализ в валидатор
            @RequestHeader(name = "User-Agent", required = false, defaultValue = "") String agent
    ) {
        User user = userService.createUser(candidate);
        if (user != null && !agent.isBlank()) statisticsService.addUserClientApp(agent);
        return user;
    }
}
