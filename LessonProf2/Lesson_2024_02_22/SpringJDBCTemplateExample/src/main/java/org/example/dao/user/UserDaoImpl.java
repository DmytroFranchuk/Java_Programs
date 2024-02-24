package org.example.dao.user;

import org.example.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

@Component
public class  UserDaoImpl implements UserDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> readAll() {
        return jdbcTemplate.query("SELECT * FROM users;", new UserMapper());
    }

    @Override
    public User read(long id) {
        List<User> users = jdbcTemplate.query("SELECT * FROM users WHERE id=?;", new UserMapper(), id);
        if (users.size() > 1) throw new IllegalStateException("Expected 1 user, but found " + users.size());
        return users.stream().findFirst().orElseThrow(() -> new NoSuchElementException("No user with id=" + id));
    }

    @Override
    public User create(User user) {
        jdbcTemplate.update(
                "INSERT INTO users (first_name, last_name, birth_date, email) VALUES (?, ?, ?, ?);",
                user.getFirstName(),
                user.getLastName(),
                user.getBirthDate() == null ? null : Date.valueOf(user.getBirthDate()),
                user.getEmail()
        );
        return findByCredentials(user.getFirstName(), user.getLastName(), user.getEmail()).orElseThrow();
    }

    @Override
    public User update(User user, long id) {
        Objects.requireNonNull(user);
        user.setId(id);
        jdbcTemplate.update(
                "UPDATE users SET first_name=?, last_name=?, birth_date=?, email=? WHERE id=?;",
                user.getFirstName(),
                user.getLastName(),
                Date.valueOf(user.getBirthDate()),
                user.getEmail(),
                id
        );
        return read(id);
    }

    @Override
    public Optional<User> findByCredentials(String firstName, String lastName, String email) {
        List<User> users = jdbcTemplate.query(
                "SELECT * FROM users WHERE first_name=? AND last_name=? AND email=?;",
                new UserMapper(),
                firstName,
                lastName,
                email
        );
        if (users.size() > 1) throw new IllegalStateException("Expected 1 user, but found " + users.size());
        return users.stream().findFirst();
    }

    @Override
    public void delete(long id) {
        jdbcTemplate.update("DELETE FROM users WHERE id=?;", id);
    }
}
