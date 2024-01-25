package org.example;

import org.example.components.LazyBean;
import org.example.config.MyAppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyAppConfig.class);
        System.out.println("Получили контекст. До этой строки создавались неленивые (EAGER) бины");
        context.getBean(LazyBean.class); // ленивый бин был создан только после запроса его из контекста
        context.close();
    }
}
