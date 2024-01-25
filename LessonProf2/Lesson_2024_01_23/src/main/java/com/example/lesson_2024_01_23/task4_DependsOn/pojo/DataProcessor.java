package com.example.lesson_2024_01_23.task4_DependsOn.pojo;

import org.springframework.stereotype.Component;

@Component
public class DataProcessor {
    private DatabaseConnection databaseConnection;

    public DataProcessor(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }
}
