package org.example;

import org.example.config.MyAppConfig;
import org.example.pojo.SpecialObjectMapperHolder;
import org.example.pojo.UsualObjectMapperHolder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyAppConfig.class);

        SpecialObjectMapperHolder sc = context.getBean("specialObjectMapperHolder", SpecialObjectMapperHolder.class);
        System.out.println("specialObjectMapperHolder made: " + sc.toJson(LocalDateTime.now()));
        UsualObjectMapperHolder tc = context.getBean("usualObjectMapperHolder", UsualObjectMapperHolder.class);
        System.out.println("usualObjectMapperHolder made: " + tc.toJson(LocalDateTime.now()));

        context.close();
    }
}
