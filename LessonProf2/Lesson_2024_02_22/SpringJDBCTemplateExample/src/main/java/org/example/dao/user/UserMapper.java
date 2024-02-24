package org.example.dao.user;

import org.example.entity.user.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new User(
                rs.getLong("id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                Optional.ofNullable(rs.getDate("birth_date")).map(Date::toLocalDate).orElse(null),
                rs.getString("email")
        );
    }
}
