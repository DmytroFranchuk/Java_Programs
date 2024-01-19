package org.lesson.springExample.task2_sprintPlantExample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main2 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        Plant p1 = context.getBean("plant", Plant.class);
        Plant p2 = context.getBean("plant", Plant.class);
        Plant p3 = context.getBean("plant", Plant.class);
        Plant p4 = context.getBean("plant", Plant.class);
        Plant p5 = context.getBean("plant", Plant.class);
    }
}
