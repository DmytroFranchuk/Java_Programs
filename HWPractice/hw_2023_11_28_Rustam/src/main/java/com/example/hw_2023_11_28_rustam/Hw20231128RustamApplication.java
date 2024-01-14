package com.example.hw_2023_11_28_rustam;

import java.sql.SQLException;
import java.util.List;

public class Hw20231128RustamApplication {

    public static void main(String[] args) throws SQLException {
        PhoneDAO phoneDAO = new PhoneDAO();
        phoneDAO.createTableIfNotExists();

        // Пример добавления телефонов
        Phone newPhone = new Phone(1,"Apple", "iPhone 13", 1099.99);
        boolean createResult = phoneDAO.create(newPhone);
        newPhone = new Phone(2, "Samsung", "Galaxy S21", 899.99);
        createResult = phoneDAO.create(newPhone);
        newPhone = new Phone(3, "Google", "Pixel 6", 799.99);
        createResult = phoneDAO.create(newPhone);
        newPhone = new Phone(4, "Samsung", "Galaxy Z Fold 3", 1799.99);
        createResult = phoneDAO.create(newPhone);
        newPhone = new Phone(5, "OnePlus", "9 Pro", 899.99);
        createResult = phoneDAO.create(newPhone);

        // Пример получения списка всех телефонов
        List<Phone> allPhones = phoneDAO.findAll();
        System.out.println("All phones: ");
        allPhones.forEach(System.out::println);

        // Пример поиска телефона по id
        Phone foundPhone = phoneDAO.findEntityById(1);
        System.out.println("");
        System.out.printf("Found phone id%s: %s%n", foundPhone.getId(), foundPhone);
        foundPhone = phoneDAO.findEntityById(5);
        System.out.printf("Found phone id%s: %s%n", foundPhone.getId(), foundPhone);

        // Пример обновления существующего телефона
        Phone phoneToUpdate = new Phone(4, "Samsung", "Galaxy Z Fold 3", 1400.00);
        Phone updatedPhone = phoneDAO.update(phoneToUpdate);
        System.out.println("");
        System.out.printf("Updated phone id%s: %s%n", updatedPhone.getId(), updatedPhone);


        // Пример удаления телефона по id
        int id = 5;
        boolean deleteByIdResult = phoneDAO.delete(id);
        System.out.println("");
        System.out.println("Delete by id: " + id + " result: " + deleteByIdResult);

        // Пример удаления телефона по объекту Phone
        id = 4;
        Phone phoneToDelete = new Phone(id, "Samsung", "Galaxy Z Fold 3", 1400.00);
        boolean deleteByObjectResult = phoneDAO.delete(phoneToDelete);
        System.out.println("");
        System.out.println("Delete by object id: " + id + " result: " + deleteByObjectResult);

        // Пример получения списка всех телефонов
        allPhones = phoneDAO.findAll();
        System.out.println("");
        System.out.println("All phones: ");
        allPhones.forEach(System.out::println);

        phoneDAO.closeConnection(null);
}}
