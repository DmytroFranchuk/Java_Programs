package org.example.dao.user;

import org.example.entity.User;
import org.example.property.DatabaseProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.*;
import java.util.*;

@Component
public class UserDaoImpl implements UserDao {
    private static DatabaseProperties dbProperties;

    @Autowired
    public UserDaoImpl(DatabaseProperties dbProperties) {
        if (UserDaoImpl.dbProperties == null) {
            try {
                Objects.requireNonNull(dbProperties.driverClassName());
                Class.forName(dbProperties.driverClassName()); // Требовалось в старых версиях Spring
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("Cannot load " + dbProperties.driverClassName(), e);
            }
        }
        UserDaoImpl.dbProperties = dbProperties;
    }

    private Connection createConnection() {
        try {
            return DriverManager.getConnection(dbProperties.url(), dbProperties.username(), dbProperties.password());
        } catch (SQLException e) {
            throw new RuntimeException("Cannot create connection to " + dbProperties.url(), e);
        }
    }

    @Override
    public List<User> readAll() {
        try (Connection connection = createConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM users;"
            );
            return toUsers(preparedStatement.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Cannot read all user", e);
        }
    }

    @Override
    public User read(long id) {
        try (Connection connection = createConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM users WHERE id=?;"
            );
            preparedStatement.setLong(1, id);
            return toUser(preparedStatement.executeQuery())
                    .orElseThrow(() -> new NoSuchElementException("No user with id=" + id));
        } catch (Exception e) {
            throw new RuntimeException("Cannot find user by credentials", e);
        }
    }

    @Override
    public User create(User user) {
        Objects.requireNonNull(user);
        try (Connection connection = createConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO users (first_name, last_name, birth_date, email) VALUES (?, ?, ?, ?);"
            );
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setDate(3, user.getBirthDate() == null ? null : Date.valueOf(user.getBirthDate()));
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Cannot create user", e);
        }
        return findByCredentials(user.getFirstName(), user.getLastName(), user.getEmail()).orElseThrow();
    }

    @Override
    public User update(User user, long id) {
        Objects.requireNonNull(user);
        user.setId(id);
        try (Connection connection = createConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE users SET first_name=?, last_name=?, birth_date=?, email=? WHERE id=?;"
            );
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setDate(3, Date.valueOf(user.getBirthDate()));
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setLong(5, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Cannot update user", e);
        }
        return read(id);
    }

    @Override
    public Optional<User> findByCredentials(String firstName, String lastName, String email) {
        try (Connection connection = createConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM users WHERE first_name=? AND last_name=? AND email=?;"
            );
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, email);
            return toUser(preparedStatement.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Cannot find user by credentials", e);
        }
    }

    @Override
    public void delete(long id) {
        try (Connection connection = createConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM users WHERE id=?;"
            );
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Cannot delete user", e);
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
}
