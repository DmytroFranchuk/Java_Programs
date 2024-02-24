package org.example.dao.stat;

import org.example.entity.StatisticsItem;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StatisticsMapper implements RowMapper<StatisticsItem> {
    @Override
    public StatisticsItem mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new StatisticsItem(
                rs.getString("client_app_name"),
                rs.getLong("client_app_count")
        );
    }
}
