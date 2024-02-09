package org.task1;

import org.task1.config.Config;
import org.task1.pojo.ColorProvider;
import org.task1.pojo.FavoritColor;
import org.task1.pojo.Rainbow;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Создайте 7 бинов цветов радуги Color в классе конфигурации. С помощью аннотации @Order задайте
// их порядок внедрения в поле типа List<Color> компонента Rainbow. Выведите поле с цветами в консоль.
// Создайте компонент ColorProvider, содержащий поле типа Map<String, Color> . Создайте метод
// получения цвета по его названию (имени бина).
public class App 
{
    public static void main( String[] args ) {
        ApplicationContext context = new
                AnnotationConfigApplicationContext(Config.class);
        System.out.println("Начало работы приложения ");
        FavoritColor service = context.getBean(FavoritColor.class);
        System.out.println(service);
        Rainbow rainbow = context.getBean(Rainbow.class);
        System.out.println(rainbow);
        ColorProvider colorProvider = context.getBean(ColorProvider.class);
        System.out.println(colorProvider);

        System.out.println();
        String[] beanNames = context.getBeanDefinitionNames();
        int number = 0;
        for (String beanName : beanNames) {
            Object bean = context.getBean(beanName);
            System.out.println("Bean " + ++number + ": " + beanName);
        }

    }
}
