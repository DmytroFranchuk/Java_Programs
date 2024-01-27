package org.task2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.task2.pojo.Config;
import org.task2.pojo.DataCollectionService;


public class MainApp2 {
    public static void main(String[] args) {
        System.out.println("Запуск программы ... ");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        DataCollectionService service = context.getBean(DataCollectionService.class);
        service.sendInfoData();
        System.out.println("Окончание программы.");
        context.close();


    }
}
