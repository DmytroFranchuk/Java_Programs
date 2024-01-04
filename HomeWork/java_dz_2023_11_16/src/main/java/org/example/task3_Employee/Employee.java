package org.example.task3_Employee;

import java.io.Serializable;

public class Employee implements Serializable {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String position;
    private transient double salary;

    public Employee(String firstName, String lastName, String dateOfBirth, String position, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.position = position;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
