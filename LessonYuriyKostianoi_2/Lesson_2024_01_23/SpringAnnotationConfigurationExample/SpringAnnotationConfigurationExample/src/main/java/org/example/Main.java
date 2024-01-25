package org.example;

import org.example.config.MyAppConfig;
import org.example.pojo.ConnectionProperties;
import org.example.pojo.FirstBean;
import org.example.pojo.FirstComponent;
import org.example.pojo.SecondBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyAppConfig.class);

        Random rnd = context.getBean("random", Random.class);
        System.out.println(rnd.nextInt(10));

        ConnectionProperties props = context.getBean(ConnectionProperties.class);
        System.out.println(props);

        FirstComponent fc = context.getBean("firstComponent", FirstComponent.class);
        System.out.println(fc);

        FirstBean fb = context.getBean("first", FirstBean.class);
        System.out.println(fb);

        SecondBean sb = context.getBean("second", SecondBean.class);
        System.out.println(sb.first());

        context.close();
    }
}
