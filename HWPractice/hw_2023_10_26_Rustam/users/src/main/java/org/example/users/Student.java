package org.example.users;

public class Student {
    int YearBirth;
    String name;
    String lastName;

    public Student(int yearBirth, String name, String lastName) {
        YearBirth = yearBirth;
        this.name = name;
        this.lastName = lastName;
    }

    public int getYearBirth() {
        return YearBirth;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "YearBirth=" + YearBirth +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
