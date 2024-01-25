package org.example;

import org.example.pojo.FirstComponent;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        FirstComponent fc = context.getBean("firstComponent", FirstComponent.class);
        System.out.println(fc);

        context.close();
    }
}
