package org.lesson.expBean;

import org.lesson.expBean.pojo.SecondBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main2 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new
                ClassPathXmlApplicationContext("applicationContext.xml");
        SecondBean sb = context.getBean("secondBean", SecondBean.class);
        System.out.println(sb.getName());
        sb.getBusinessLogic().doBusinessLogic();

        context.close();
    }
}
