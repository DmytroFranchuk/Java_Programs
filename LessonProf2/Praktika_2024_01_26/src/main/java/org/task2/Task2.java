package org.task2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.annotation.Annotation;

// 1.1 Напишите простое приложение для составления списка покупок. Создайте бины продуктов
// (можно создать класс FoodItem с полями name и expirationDate и сделать разные бины),
// и бин холодильника, хранящий продукты в заданном количестве. Путь expirationDate выбирается
// произвольным образом. Чтобы внедрить все виды продуктов в холодильник при создании холодильника
// сделайте внедрение List<FoodItem> или FoodItem[]. После этого приложение должно уточнить у
// пользователя, сколько каких продуктов должно быть в холодильнике и сколько есть в настоящий момент.
public class Task2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        context.registerBean("context", ApplicationContext.class, context);
        //context.refresh();
        Refrigerator refrigerator = context.getBean(Refrigerator.class);
        System.out.println(refrigerator.getProductToActualToExpectedCount());
        context.close();

    }
}
