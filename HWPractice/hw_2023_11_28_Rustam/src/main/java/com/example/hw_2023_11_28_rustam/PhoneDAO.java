package com.example.hw_2023_11_28_rustam;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneDAO {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private static final String URL = "jdbc:h2:mem:testdb";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "password";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public boolean isTableExists(Connection connection, String tableName) throws SQLException {
        DatabaseMetaData metaData = connection.getMetaData();
        try (ResultSet tables = metaData.getTables(null, null, tableName, null)) {
            return tables.next();
        }
    }

    public void createTableIfNotExists() {
        try {
            Connection connection = getConnection();
            String sql = "CREATE TABLE IF NOT EXISTS PHONES (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "brand VARCHAR(255)," +
                    "model VARCHAR(255)," +
                    "price DOUBLE" +
                    ")";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
            if (isTableExists(connection, "PHONES")) {
                this.connection = connection;
                this.preparedStatement = preparedStatement;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Phone findEntityById(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Phone phone = null;
        try {
            connection = DriverManager.getConnection(URL);

            String sql = "SELECT * FROM phones WHERE id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                phone = new Phone(
                        resultSet.getInt("id"),
                        resultSet.getString("brand"),
                        resultSet.getString("model"),
                        resultSet.getDouble("price")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(resultSet);
        }
        return phone;
    }

    public List<Phone> findAll() {
        List<Phone> phones = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
//            Class.forName("org.h2.Driver");
            connection = getConnection();
            statement = connection.createStatement();
            String sql = "SELECT id, brand, model, price FROM PHONES";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Phone phone = new Phone(
                        resultSet.getInt("id"),
                        resultSet.getString("brand"),
                        resultSet.getString("model"),
                        resultSet.getDouble("price")
                );
                phones.add(phone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(resultSet);
        }
        return phones;
    }

    public boolean delete(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            String sql = "DELETE FROM phones WHERE id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            closeConnection(null);
        }
    }

    public boolean delete(Phone phone) {
        if (phone == null) {
            return false;
        }
        return delete(phone.getId());
    }

    public boolean create(Phone phone) {
        if (phone == null) {
            return false;
        }
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            String sql = "INSERT INTO PHONES (id, brand, model, price) VALUES (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, phone.getId());
            preparedStatement.setString(2, phone.getBrand());
            preparedStatement.setString(3, phone.getModel());
            preparedStatement.setDouble(4, phone.getPrice());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            closeConnection(null);
        }
    }

    public Phone update(Phone phone) {
        if (phone == null) {
            return null;
        }
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            String sql = "UPDATE PHONES SET brand=?, model=?, price=? WHERE id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, phone.getBrand());
            preparedStatement.setString(2, phone.getModel());
            preparedStatement.setDouble(3, phone.getPrice());
            preparedStatement.setInt(4, phone.getId());
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return phone;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(null);
        }
        return null;
    }

    public void closeConnection(ResultSet resultSet) {
        try {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
