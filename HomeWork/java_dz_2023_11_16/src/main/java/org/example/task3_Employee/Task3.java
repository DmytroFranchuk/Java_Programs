package org.example.task3_Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Создайте класс Сотрудник с полями имя, фамилия, дата рождения, должность, заработная плата.
// Сериализуйте объект и сохраните в файл. Поле заработной платы сериализовать не нужно, т.к. это
// коммерческая тайна организации.
public class Task3 {

    public static void main(String[] args) {
        Employee employee1 = new Employee("Иван", "Иванов", "1979-01-28", "электрик", 1300);
        Employee employee2 = new Employee("Роман", "Романов", "1993-10-03", "программист", 2700);
        Employee employee3 = new Employee("Вася", "Васютин", "1984-04-30", "врач", 4200);
        Employee employee4 = new Employee("Зоя", "Зорянина", "1989-09-21", "инженер", 4700);
        Employee employee5 = new Employee("Аня", "Анютина", "1999-05-16", "повар", 2300);
        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);

        serialization(employees, "employees.txt");
        List<Employee> deserializationEmployees = deserialization("employees.txt");
        for (Employee empl : deserializationEmployees) {
            System.out.println(empl);
        }
    }

    public static void serialization(List<Employee> employees, String fileName) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(employees);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Employee> deserialization(String path) {
        List<Employee> employees = null;
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(path))) {
            employees = (List<Employee>) input.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }
}
