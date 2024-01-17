package org.lesson.expBean;

import org.lesson.expBean.pojo.ThirdBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main3 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new
                ClassPathXmlApplicationContext("applicationContext.xml");
        ThirdBean tb = context.getBean("thirdBean", ThirdBean.class);
        System.out.println(tb.getFirstBean().getName());
        tb.getBusinessLogic().doBusinessLogic();

        ThirdBean tb2 = context.getBean("thirdBean", ThirdBean.class);
        System.out.println("Если достать второй такой же бин из контекста, то мы получаем новый объект: " + (tb==tb2));

        context.close();
    }
}
