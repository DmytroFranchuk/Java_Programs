package com.example.demoBeanAnnotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppBeanConfig {
    @Bean
    public Student student() {
        Student student = new Student();
        student.setId(2L);
        student.setAge(30);
        student.setEmail("ostap@gmail.com");
        student.setName("Ostap");
        return student;
    }

}
