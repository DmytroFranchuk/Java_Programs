package org.example.mapper;


import org.example.entity.dish.Dish;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DishDaoMapper implements RowMapper<Dish> {

    @Override
    public Dish mapRow(ResultSet rs, int rowNum) throws SQLException {
        return  new Dish(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("ingredients"));
    }
}
