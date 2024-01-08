package com.example.demoBeanAnnotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class, args);
        Student student = context.getBean(Student.class);
        System.out.println("===============================================");
        System.out.println("Student ID: " + student.getId());
        System.out.println("Student Age: " + student.getAge());
        System.out.println("Student Email: " + student.getEmail());
        System.out.println("Student Name: " + student.getName());
        System.out.println("===============================================");
    }
}
