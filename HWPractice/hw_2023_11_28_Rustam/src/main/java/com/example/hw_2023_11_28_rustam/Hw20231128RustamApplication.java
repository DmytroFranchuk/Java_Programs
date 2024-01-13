package com.example.hw_2023_11_28_rustam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Hw20231128RustamApplication {

    public static void main(String[] args) throws SQLException {
        PhoneDAO phoneDAO = new PhoneDAO();
//        phoneDAO.createTableIfNotExists();
        String sql = "CREATE TABLE IF NOT EXISTS PHONES (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "brand VARCHAR(255)," +
                "model VARCHAR(255)," +
                "price DOUBLE" +
                ")";
        Connection connection = DriverManager.getConnection("jdbc:h2:mem:testdb");
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.execute();

        System.out.println(phoneDAO.isTableExists(connection, "PHONES"));

        // Пример добавления нового телефона
        Phone newPhone = new Phone(1,"Apple", "iPhone 13", 1099.99);
        boolean createResult = phoneDAO.create(newPhone);
        System.out.println("Create result: " + createResult);

//        // Пример поиска телефона по id
//        Phone foundPhone = phoneDAO.findEntityById(1);
//        System.out.println("Found phone: " + foundPhone);

        // Пример получения списка всех телефонов
        List<Phone> allPhones = phoneDAO.findAll();
        System.out.println("All phones: " + allPhones);
//
//        // Пример удаления телефона по id
//        boolean deleteByIdResult = phoneDAO.delete(2);
//        System.out.println("Delete by id result: " + deleteByIdResult);
//
//        // Пример удаления телефона по объекту Phone
//        Phone phoneToDelete = new Phone(3, "Samsung", "Galaxy S21", 899.99);
//        boolean deleteByObjectResult = phoneDAO.delete(phoneToDelete);
//        System.out.println("Delete by object result: " + deleteByObjectResult);
//

//
//        // Пример обновления существующего телефона
//        Phone phoneToUpdate = new Phone(4, "Google", "Pixel 6", 799.99);
//        Phone updatedPhone = phoneDAO.update(phoneToUpdate);
//        System.out.println("Updated phone: " + updatedPhone);
//    }
}}
