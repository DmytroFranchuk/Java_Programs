package org.springExample.task5_Immunity;

import org.springExample.task5_Immunity.model.disease.Organism;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("beans2.xml");
//        Immunity immunity = context.getBean(Immunity.class);
//        immunity.getVaccinations().printName();
//        Immunity immunity2 = context.getBean(Immunity.class);
//        immunity2.getVaccinations().printName();
//        System.out.println((immunity == immunity2));

        Organism organism = context.getBean(Organism.class);
        System.out.println(organism);
        context.close();


    }
}
// 1 Создайте класс Иммунитет, содержащий поле типа Прививка.
// Прививка – интерфейс. Сделайте разные имплементации прививки (от кори, от бешенства, от гриппа, от короновируса).
// Создайте несколько бинов иммунитета, каждый иммунитет должен быть инжектирован своей прививкой:
// иммунитет против кори, иммунитет против бешенства и т.д.
// Внедрите все иммунитеты в бин Организм.