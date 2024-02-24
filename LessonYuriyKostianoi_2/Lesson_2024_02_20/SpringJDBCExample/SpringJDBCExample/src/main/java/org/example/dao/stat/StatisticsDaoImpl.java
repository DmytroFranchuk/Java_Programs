package org.example.dao.stat;

import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class StatisticsDaoImpl implements StatisticsDao {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/UserDB";
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

    public StatisticsDaoImpl() {

    }

    @Override
    public Map<String, Long> getStatistics() {
        try {
            Statement statement = CONNECTION.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM client_app_statistics;");
            Map<String, Long> clientAppToCount = new HashMap<>();
            while (result.next()) {
                clientAppToCount.put(
                        result.getString("client_app_name"),
                        result.getLong("client_app_count")
                );
            }
            return clientAppToCount;
        } catch (SQLException e) {
            throw new RuntimeException("Cannot get statistics", e);
        }
    }

    @Override
    public void addStatistics(String agent) {
        boolean isExist = getStatistics().entrySet().stream().anyMatch(p -> p.getKey().equals(agent));
        try {
            Statement statement = CONNECTION.createStatement();
            if (isExist) statement.executeUpdate(
                        "UPDATE client_app_statistics SET client_app_count = client_app_count + 1 WHERE client_app_name = '" + agent + "'"
                );
            else statement.executeUpdate(
                        "INSERT INTO client_app_statistics (client_app_name, client_app_count) values ('" + agent + "', 1);"
                );
        } catch (SQLException e) {
            throw new RuntimeException("Cannot add statistics for " + agent, e);
        }
    }
}
