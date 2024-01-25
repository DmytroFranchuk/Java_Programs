package com.example.lesson_2024_01_23.task4_DependsOn.pojo;
// Создайте бин DataProcessor, который зависит от бина DatabaseConnection.
// В свою очередь DatabaseConnection не может существовать, пока база данных не будет
// проинициализирована бином DatabaseInitializer. Обеспечьте корректный порядок инициализации бинов.
public class DatabaseInitializer {
    public DatabaseInitializer() {
        initializeDataBase();
    }

    public static void initializeDataBase() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Database is initialized");
    }
}
