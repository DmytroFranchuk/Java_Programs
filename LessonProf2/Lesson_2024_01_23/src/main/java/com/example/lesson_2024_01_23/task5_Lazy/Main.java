package com.example.lesson_2024_01_23.task5_Lazy;

import com.example.lesson_2024_01_23.task5_Lazy.config.AppConfig;
import com.example.lesson_2024_01_23.task5_Lazy.pojo.CertificateService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Допустим, у Вас есть сервис, который выполняет долгую (30 сек) операцию получения
// сертификатов доступа к внутренней сети предприятия при старте приложения из
// корпоративного сервера. Вам необходимо избежать замедления старта приложения и
// отложить инициализацию этого сервиса до момента его первого вызова. Сравните
// скорость запуска приложения с использованием @Lazy и без неё

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new
                AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println("Начало работы приложения ");
        CertificateService service = context.getBean(CertificateService.class);

        System.out.println();
        String[] beanNames = context.getBeanDefinitionNames();
        int number = 0;
        for (String beanName : beanNames) {
            Object bean = context.getBean(beanName);
            System.out.println("Bean " + ++number + ": " + beanName);
        }


//        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
//            System.out.println("Начало работы приложения ");
//            CertificateService service = context.getBean(CertificateService.class);
//
//            System.out.println();
//            int beanCount = context.getBeanDefinitionCount();
//            System.out.println("Количество зарегистрированных бинов: " + beanCount);
//
//            String[] beanNames = context.getBeanDefinitionNames();
//            int number = 0;
//            for (String beanName : beanNames) {
//                Object bean = context.getBean(beanName);
//                System.out.println("Bean " + ++number + ": " + beanName);
//            }
//        }
    }
}
