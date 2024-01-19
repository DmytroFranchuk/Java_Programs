package org._lessonExamples.SpringXmlFactoryMethodExample;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans/SpringXmlFactoryMethodExample.xml");

        LocalDate logger = context.getBean("localDateNow", LocalDate.class);
        System.out.println(logger); // выведет сегодняшнюю дату
        context.close();
    }
}
