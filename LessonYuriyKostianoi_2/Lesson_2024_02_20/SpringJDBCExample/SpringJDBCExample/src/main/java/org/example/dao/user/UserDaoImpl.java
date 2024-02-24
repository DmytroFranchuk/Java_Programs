package org.example.dao.user;

import lombok.NoArgsConstructor;
import org.example.entity.User;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Component
@NoArgsConstructor
public class UserDaoImpl implements UserDao {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/UserDB"; // TODO вынести в файл настроек
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "1";
    private static final String DRIVER_CLASS_NAME = "org.postgresql.Driver";
    private static final Connection CONNECTION;

    static {
        try {
            Class.forName(DRIVER_CLASS_NAME); // Требовалось в старых версиях Spring
            CONNECTION = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Cannot load " + DRIVER_CLASS_NAME, e);
        } catch (SQLException e) {
            throw new RuntimeException("Cannot create connection to " + DB_URL, e);
        }
    }

    @Override
    public List<User> readAll() {
        return toUsers(completeQuery("SELECT * FROM users").orElseThrow());
    }

    @Override
    public User read(long id) {
        return toUser(completeQuery("SELECT * FROM users WHERE id=" + id).orElseThrow())
                .orElseThrow(() -> new NoSuchElementException("No user with id=" + id));
    }

    private Optional<ResultSet> completeQuery(String query) {
        try {
            Statement statement = CONNECTION.createStatement();
            if (query.contains("UPDATE") || query.contains("INSERT") || query.contains("DELETE")) {
                statement.executeUpdate(query);
                return Optional.empty();
            }

            return Optional.of(statement.executeQuery(query));
        } catch (SQLException e) {
            throw new RuntimeException("Cannot complete query " + query, e);
        }
    }

    private List<User> toUsers(ResultSet result) {
        List<User> users = new ArrayList<>();
        try {
            while (result.next()) {
                User user = new User(
                        result.getLong("id"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        Optional.ofNullable(result.getDate("birth_date")).map(Date::toLocalDate).orElse(null),
                        result.getString("email")
                );
                users.add(user);
            }
            closeResult(result);
        } catch (SQLException e) {
            throw new RuntimeException("Cannot extract data from query result", e);
        }
        return users;
    }

    private Optional<User> toUser(ResultSet result) {
        List<User> users = toUsers(result);
        if (users.size() > 1) throw new RuntimeException("Expected the only user, but found " + users.size());
        return users.stream().findFirst();
    }

    private void closeResult(ResultSet result) {
        if (result != null) {
            try {
                result.close();
            } catch (SQLException ignore) {
            }
        }
    }

    @Override
    public User create(User user) {
        Objects.requireNonNull(user);
        completeQuery(
                prepareQuery(
                        "INSERT INTO users (first_name, last_name, birth_date, email) VALUES (%s, %s, %s, %s);",
                        user.getFirstName(),
                        user.getLastName(),
                        user.getBirthDate(),
                        user.getEmail()
                )
        );
        return findByCredentials(user.getFirstName(), user.getLastName(), user.getEmail()).orElseThrow();
    }

    private String prepareQuery(String pattern, Object... args) {
        Object[] preparedArgs = Arrays.stream(args).map(a -> {
            if (a instanceof Number) return a.toString();
            if (a instanceof LocalDate) return surroundAsSqlStr(((LocalDate) a).format(FORMATTER));
            return surroundAsSqlStr(a);
        }).toArray();
        return String.format(pattern, preparedArgs);
    }

    private String surroundAsSqlStr(Object obj) {
        return obj == null ? "NULL" : '\'' + obj.toString() + '\'';
    }

    @Override
    public User update(User user, long id) {
        Objects.requireNonNull(user);
        user.setId(id);
        completeQuery(
                prepareQuery(
                        "UPDATE users SET first_name=%s, last_name=%s, birth_date=%s, email=%s WHERE id=%s;",
                        user.getFirstName(),
                        user.getLastName(),
                        user.getBirthDate(),
                        user.getEmail(),
                        user.getId()
                )
        );
        return read(id);
    }

    @Override
    public Optional<User> findByCredentials(String firstName, String lastName, String email) {
        return toUser(
                completeQuery(
                        prepareQuery(
                                "SELECT * FROM users WHERE first_name=%s AND last_name=%s AND email=%s;",
                                firstName,
                                lastName,
                                email
                        )
                ).orElseThrow()
        );
    }

    @Override
    public void delete(long id) {
        completeQuery("DELETE FROM users WHERE id=" + id);
    }
}
