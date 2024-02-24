package org.example.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.example.dto.UserDto;
import org.example.service.StatisticsService;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Validated
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
    public List<UserDto> getUsers(
            @RequestParam(value = "lastNameStartsWith", required = false, defaultValue = "") String lastNameStartsWith
    ) {
        return userService.getUsers(lastNameStartsWith);
    }

    @GetMapping("/users/{id}")
    public UserDto getUser(@PathVariable("id") @Min(0) long id) {
        return userService.getUser(id);
    }

    @PostMapping(path = "/users",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDto createUser(
            @RequestBody @Valid UserDto candidate,
            @RequestHeader(name = "User-Agent", required = false, defaultValue = "") String agent
    ) {
        UserDto userDto = userService.createUser(candidate);
        if (userDto != null && !agent.isBlank()) statisticsService.addUserClientApp(agent);
        return userDto;
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable("id") @Min(0) long id) {
        Optional<UserDto> opUser = userService.getUsers("").stream().filter(u -> u.id() == id).findFirst();
        if (opUser.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Can't find user with id=" + id);
        userService.deleteUser(opUser.get().id());
    }
}
