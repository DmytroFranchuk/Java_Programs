package org._lessonExamples.SpringAnnotationAutowiredExample;

import org._lessonExamples.SpringAnnotationAutowiredExample.pojo.SecondComponent;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main1 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new
                ClassPathXmlApplicationContext("SpringAnnotationAutowiredExample.xml");
        SecondComponent fc = context.getBean("secondComponent", SecondComponent.class);
        System.out.println(fc);
        context.close();
    }
}
