package org.example.dao.stat;

import org.example.entity.StatisticsItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StatisticsDaoImpl implements StatisticsDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StatisticsDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<StatisticsItem> getStatistics() {
        return jdbcTemplate.query("SELECT * FROM client_app_statistics;", new StatisticsMapper());
    }

    @Override
    public void addStatistics(String agent) {
        boolean isExist = getStatistics().stream().anyMatch(s -> s.clientAppName().equals(agent));
        if (isExist) jdbcTemplate.update(
                "UPDATE client_app_statistics SET client_app_count = client_app_count + 1 WHERE client_app_name = ?",
                agent
        );
        else jdbcTemplate.update(
                "INSERT INTO client_app_statistics (client_app_name, client_app_count) values (?, 1);",
                agent
        );
    }
}
