package org._lessonExamples.SpringAnnotationComponentExample;

import org._lessonExamples.SpringAnnotationComponentExample.pojo.FirstComponent;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new
                ClassPathXmlApplicationContext("SpringAnnotationComponentExample.xml");
        FirstComponent fc = context.getBean("firstComponent", FirstComponent.class);
        System.out.println(fc);
        context.close();
    }
}
