package com.example.codExample.SpringAnnotationLazyExample;

import com.example.codExample.SpringAnnotationLazyExample.components.LazyBean;
import com.example.codExample.SpringAnnotationLazyExample.config.MyAppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyAppConfig.class);
        System.out.println("Получили контекст. До этой строки создавались неленивые (EAGER) бины");
//        context.getBean(LazyBean.class); // ленивый бин был создан только после запроса его из контекста

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
