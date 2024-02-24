package org.example.dao.stat;

import org.example.property.DatabaseProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
public class StatisticsDaoImpl implements StatisticsDao {

    private static DatabaseProperties dbProperties;

    @Autowired
    public StatisticsDaoImpl(DatabaseProperties dbProperties) {
        if (StatisticsDaoImpl.dbProperties == null) {
            try {
                Objects.requireNonNull(dbProperties.driverClassName());
                Class.forName(dbProperties.driverClassName());
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("Cannot load " + dbProperties.driverClassName(), e);
            }
        }
        StatisticsDaoImpl.dbProperties = dbProperties;
    }

    private Connection createConnection() {
        try {
            return DriverManager.getConnection(dbProperties.url(), dbProperties.username(), dbProperties.password());
        } catch (SQLException e) {
            throw new RuntimeException("Cannot create connection to " + dbProperties.url(), e);
        }
    }

    @Override
    public Map<String, Long> getStatistics() {
        try (Connection connection = createConnection()) {
            Statement statement = connection.createStatement();
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
        try (Connection connection = createConnection()) {
            Statement statement = connection.createStatement();
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
