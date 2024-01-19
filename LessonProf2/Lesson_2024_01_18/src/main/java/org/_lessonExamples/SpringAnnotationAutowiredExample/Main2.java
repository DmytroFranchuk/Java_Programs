package org._lessonExamples.SpringAnnotationAutowiredExample;

import org._lessonExamples.SpringAnnotationAutowiredExample.pojo.ThirdComponent;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main2 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new
                ClassPathXmlApplicationContext("SpringAnnotationAutowiredExample.xml");
        ThirdComponent tc = context.getBean("thirdComponent", ThirdComponent.class);
        System.out.println(tc);
        context.close();
    }
}
