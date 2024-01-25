package com.example.lesson_2024_01_23.task1_properties;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.UUID;

// Создайте Spring-приложение, которое получает настройки host, port и token из файла
// application.properties, используя @Value.
// В ранее созданном приложении залогируйте настройки после их получения из файла.
// Во время работы программы токен должен поменяться (сгенерируйте с помощью UUID).
// Перед уничтожением бина замените токен в файле конфигурации на значение, хранящееся в бине.

//@ComponentScan
//@SpringBootApplication
public class MainApp {

    public static void main(String[] args) {
//        SpringApplication.run(Lesson20240123Application.class, args);
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("newBean.xml");
        ConnectionProperties connectionProperties = context.getBean("connectionProperties", ConnectionProperties.class);
        connectionProperties.setToken(UUID.randomUUID().toString());
        //        System.out.println(connectionProperties.host());
//        System.out.println(connectionProperties.port());
//        System.out.println(connectionProperties.token());
        System.out.println();

        context.close();

    }

}
