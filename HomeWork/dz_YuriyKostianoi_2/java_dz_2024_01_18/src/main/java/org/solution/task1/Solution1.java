package org.solution.task1;

import org.solution.task1.model.Car;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Solution1 {
    public static void main( String[] args ) {
        var context = new ClassPathXmlApplicationContext("appContext.xml");
        var car = context.getBean(Car.class);

        car.initializeEngine(250);
        car.getEngine().start();
        car.getEngine().stop();

        car.initializeEngine(100);
        car.getEngine().start();
        car.getEngine().stop();

        String[] beanNames = context.getBeanDefinitionNames();
        System.out.println();
        int number = 0;
        for (String beanName : beanNames) {
            Object bean = context.getBean(beanName);
            System.out.println("Bean_" + ++number + ": " + beanName + ", Type: " + bean.getClass().getName());
        }
    }
}

// Ваш класс Car зависит от интерфейса Engine.
// Создайте несколько реализаций интерфейса Engine (например, GasEngine и ElectricEngine).
// Аннотируйте их с помощью @Component с названием бинов, чтобы явно указать, какой двигатель
// должен быть использован в каждом случае.
// Затем внедрите зависимость двигателя в класс Car с помощью @Autowired и @Qualifier,
// чтобы можно было выбрать тип двигателя во время компиляции.
