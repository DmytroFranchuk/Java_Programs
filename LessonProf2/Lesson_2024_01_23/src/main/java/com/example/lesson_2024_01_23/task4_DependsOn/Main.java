package com.example.lesson_2024_01_23.task4_DependsOn;

import com.example.lesson_2024_01_23.task3_Primary.season.Config;
import com.example.lesson_2024_01_23.task4_DependsOn.config.AppConfig;
import com.example.lesson_2024_01_23.task4_DependsOn.pojo.DataProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context  = new AnnotationConfigApplicationContext(AppConfig.class);
        DataProcessor p1 = context.getBean( DataProcessor.class);
        System.out.println(p1);


        System.out.println();
        String[] beanNames = context.getBeanDefinitionNames();
        int number = 0;
        for (String beanName : beanNames) {
            Object bean = context.getBean(beanName);
            System.out.println("Bean " + ++number + ": " + beanName);
        }
        context.close();

    }
}
// @Profile()
// Аннотация @Profile в Spring Framework используется для определения условий активации компонентов
// в зависимости от текущего профиля приложения. Это позволяет настроить приложение для различных сред,
// таких как разработка, тестирование и продуктивная эксплуатация.

// Предположим, у вас есть класс компонента, который вы хотите активировать только в определенном профиле,
// например, в профиле "development".
// import org.springframework.context.annotation.Profile;
// import org.springframework.stereotype.Component;
//
// @Component
// @Profile("development")
// public class DevelopmentConnector implements Connector {
//
//    // Реализация для профиля "development"
//
// }

// Здесь мы используем @Profile("development") для указания, что компонент DevelopmentConnector должен
// быть активирован только в том случае, если текущий профиль приложения установлен в "development".

// В вашем конфигурационном классе (например, классе с аннотацией @Configuration), вы также можете указать
// активные профили с помощью аннотации @ActiveProfiles
// В вашем конфигурационном классе (например, классе с аннотацией @Configuration), вы также можете указать
// активные профили с помощью аннотации @ActiveProfiles

// import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.Profile;
// import org.springframework.context.annotation.ComponentScan;
// import org.springframework.test.context.ActiveProfiles;
//
// @Configuration
// @ComponentScan(basePackages = "com.example.lesson_2024_01_23.task2_AnnotationConfigApplicationContext")
// @ActiveProfiles("development")
// public class AppConfig {
//    // Конфигурация приложения
// }
// В этом примере мы используем @ActiveProfiles("development"), чтобы установить профиль "development"
// в тестовой конфигурации. Это позволяет активировать компоненты, помеченные
// аннотацией @Profile("development").