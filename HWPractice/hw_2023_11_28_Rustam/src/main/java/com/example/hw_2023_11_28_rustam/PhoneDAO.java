package com.example.hw_2023_11_28_rustam;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneDAO {
    private static final String URL = "jdbc:h2:mem:testdb";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "password";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public void closeConnection(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isTableExists(Connection connection, String tableName) throws SQLException {
        DatabaseMetaData metaData = connection.getMetaData();
        try (ResultSet tables = metaData.getTables(null, null, tableName, null)) {
            return tables.next();
        }
    }

    public Phone findEntityById(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Phone phone = null;
        try {
            connection = getConnection();

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
            closeConnection(connection, preparedStatement, resultSet);
        }
        return phone;
    }

    public List<Phone> findAll() {
        List<Phone> phones = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection(URL);
//            DatabaseMetaData metaData = connection.getMetaData();
//            System.out.println("Connected to database as user: " + metaData.getUserName() +
//                    " " + metaData.getConnection() + " " + metaData.getURL());
            statement = connection.createStatement();
            String sql = "SELECT id, brand, model, price FROM PHONES";
            resultSet = statement.executeQuery(sql);
//            System.out.println("Код телефона: " + sql);
            while (resultSet.next()) {
                Phone phone = new Phone(
                        resultSet.getInt("id"),
                        resultSet.getString("brand"),
                        resultSet.getString("model"),
                        resultSet.getDouble("price")
                );
                System.out.println("Код телефона: " + phone);
                phones.add(phone);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection, statement, resultSet);
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
            closeConnection(connection, preparedStatement, null);
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
            connection = DriverManager.getConnection("jdbc:h2:mem:testdb");
            String sql = "INSERT INTO PHONES (id, brand, model, price) VALUES (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, phone.getId());
            preparedStatement.setString(1, phone.getBrand());
            preparedStatement.setString(2, phone.getModel());
            preparedStatement.setDouble(3, phone.getPrice());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            closeConnection(connection, preparedStatement, null);
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
            String sql = "UPDATE phones SET brand=?, model=?, price=? WHERE id=?";
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
            closeConnection(connection, preparedStatement, null);
        }
        return null;
    }

    public void createTableIfNotExists() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();

            // SQL-запрос для создания таблицы
            String sql = "CREATE TABLE IF NOT EXISTS PHONES (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "brand VARCHAR(255)," +
                    "model VARCHAR(255)," +
                    "price DOUBLE" +
                    ")";

            preparedStatement = connection.prepareStatement(sql);

            // Выполнение SQL-запроса
            preparedStatement.execute();

            System.out.println("Table PHONES created successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection, preparedStatement, null);
        }
    }
}
