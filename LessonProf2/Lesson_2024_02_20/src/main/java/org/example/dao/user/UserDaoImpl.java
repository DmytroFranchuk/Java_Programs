package org.example.dao.user;

import org.example.entity.User;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserDaoImpl implements UserDao {
    private static long counter = 0L;
    private final Map<Long, User> idToUser;

    public UserDaoImpl() {
        idToUser = new HashMap<>();
    }

    @Override
    public User create(User user) {
        long id = counter++;
        Objects.requireNonNull(user);
        user.setId(id);
        idToUser.put(id, user);
        return read(id);
    }

    @Override
    public User read(long id) {
        return idToUser.get(id);
    }

    @Override
    public List<User> readAll() {
        return idToUser.values().stream().toList();
    }

    @Override
    public User update(User user, long id) {
        Objects.requireNonNull(user);
        user.setId(id);
        idToUser.put(id, user);
        return read(id);
    }

    @Override
    public Optional<User> findByCredentials(String firstName, String lastName, String email) {
        return idToUser.values().stream()
                .filter(u -> Objects.equals(u.getLastName(), lastName) &&
                        Objects.equals(u.getFirstName(), firstName) &&
                        Objects.equals(u.getEmail(), email))
                .findFirst();
    }

    @Override
    public void delete(long id) {
        idToUser.remove(id);
    }
}
