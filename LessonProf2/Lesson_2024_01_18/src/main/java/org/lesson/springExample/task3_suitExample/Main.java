package org.lesson.springExample.task3_suitExample;

import org.lesson.springExample.task3_suitExample.entity.Suit;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("newBean.xml");
        Suit fc = context.getBean("suit", Suit.class);
        Suit fc2 = context.getBean("suit", Suit.class);
        fc.getJacket().wearJacket();
        fc.getTrousers().winkle();
        fc.getShirt().iron();
        fc.getTie().tie();

        System.out.println((fc == fc2));
        context.close();
    }
}
