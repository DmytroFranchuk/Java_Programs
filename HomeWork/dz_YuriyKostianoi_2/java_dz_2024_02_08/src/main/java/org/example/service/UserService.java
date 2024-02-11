package org.example.service;

import org.example.dto.Status;
import org.example.dto.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final List<User> users;

    public UserService() {
        users = new ArrayList<>();
        users.add(new User(1L, "Boris", "Johnson", LocalDate.of(1975, 2, 17), "funny_boris@gmail.uk", Status.BLOCKED));
        users.add(new User(2L, "Donald", "Duck", LocalDate.of(1976, 6, 16), "donald@ducks.burg", Status.BLOCKED));
        users.add(new User(3L, "Tommy", "Trouble", LocalDate.of(1970, 12, 24), "t_t@jail.in", Status.BLOCKED));
    }

    public List<User> getUsers(String lastNameStartsWith) {
        return lastNameStartsWith.isBlank() ? new ArrayList<>(users) : users.stream()
                .filter(u -> u.lastName().startsWith(lastNameStartsWith))
                .toList();
    }

    public List<User> getAllUsers() {
        return users;
    }

    public User getUser(long id) {
        return users.stream().filter(u -> u.id() == id).findFirst().orElseThrow();
    }

    public User createUser(User candidate) {
        if (candidate.id() != null) throw new IllegalStateException("Пользователь не создан, т.к. id не равен null");
        if (users.stream().anyMatch(u -> u.lastName().equals(candidate.lastName()) &&
                u.firstName().equals(candidate.firstName()) &&
                u.email().equals(candidate.email())))
            throw new IllegalStateException("Пользователь с указанными фамилией, именем и email уже существует");

        User user = new User(candidate);
        users.add(user);
        return user;
    }

    public User updateUser(long id, User user) {
        user = new User(id, user.firstName(), user.lastName(), user.birthDate(), user.email(), user.status());
        users.removeIf(u -> u.id() == id);
        users.add(user);
        return user;
    }

    public User updateStatus(Long userId, Status status) {
        User old = getUser(userId);
        User userNew = new User(old.id(), old.firstName(), old.lastName(), old.birthDate(), old.email(), status);
        users.removeIf(u -> userId.equals(u.id()));
        users.add(userNew);
        return userNew;
    }
}
