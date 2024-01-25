package com.example.lesson_2024_01_23.task2_AnnotationConfigApplicationContext;
// Переведите ранее созданное приложение на конфигурацию без использования xml.
// Создайте класс Connector, который использует бин настроек приложения (host, port и token).
// В классе создайте метод, эмулирующий подключение к удалённому серверу.
// Получите бин Connector из контекста и запустите метод подключения.


import com.example.lesson_2024_01_23.task2_AnnotationConfigApplicationContext.config.AppConfig;
import com.example.lesson_2024_01_23.task2_AnnotationConfigApplicationContext.connect.Connector;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new
                AnnotationConfigApplicationContext(AppConfig.class);
        Connector connector = context.getBean("connector", Connector.class);
        connector.connect();
        context.close();


    }
}
