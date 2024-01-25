package com.example.lesson_2024_01_23.task4_DependsOn.config;

import com.example.lesson_2024_01_23.task4_DependsOn.pojo.DataProcessor;
import com.example.lesson_2024_01_23.task4_DependsOn.pojo.DatabaseConnection;
import com.example.lesson_2024_01_23.task4_DependsOn.pojo.DatabaseInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
@ComponentScan("com.example.lesson_2024_01_23.task4_DependsOn.config")
public class AppConfig {

    @Bean
    public DatabaseInitializer databaseInitializer(){
        return new DatabaseInitializer();
    }

    @Bean
    @DependsOn ("databaseInitializer")
    public DatabaseConnection databaseConnection(){
        return new DatabaseConnection();
    }

    @Bean
    public DataProcessor dataProcessor(){
        return new DataProcessor(databaseConnection());
    }
}
