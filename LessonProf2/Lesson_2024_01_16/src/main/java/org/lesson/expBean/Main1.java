package org.lesson.expBean;

import org.lesson.expBean.pojo.FirstBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main1 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new
                ClassPathXmlApplicationContext("applicationContext.xml");
        FirstBean fb = context.getBean("firstBean", FirstBean.class);
        System.out.println(fb.getName());

        FirstBean fb2 = context.getBean("firstBean", FirstBean.class);
        System.out.println("Если достать второй такой же бин из контекста, то мы получаем тот же объект: " + (fb==fb2));

        context.close();
    }
}
