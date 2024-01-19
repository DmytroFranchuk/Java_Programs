package org._lessonExamples.SpringAnnotationScopeExample;

import org._lessonExamples.SpringAnnotationScopeExample.pojo.SecondComponent;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new
                ClassPathXmlApplicationContext("beans/SpringAnnotationScopeExample.xml");
        SecondComponent fc1 = context.getBean("secondComponent", SecondComponent.class);
        SecondComponent fc2 = context.getBean("secondComponent", SecondComponent.class);
        System.out.println("Are the same bean: " + (fc1 == fc2));
        context.close();
    }
}
