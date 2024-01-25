package com.example.lesson_2024_01_23.task2_AnnotationConfigApplicationContext.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan({
        "com.example.lesson_2024_01_23.task1_properties",
        "com.example.lesson_2024_01_23.task2_AnnotationConfigApplicationContext.connect"
})
@PropertySource("classpath:application.properties")
public class AppConfig {

}
