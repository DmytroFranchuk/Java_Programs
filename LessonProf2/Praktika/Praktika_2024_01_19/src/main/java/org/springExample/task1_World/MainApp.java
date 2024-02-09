package org.springExample.task1_World;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp
{
    public static void main( String[] args ) {
        ClassPathXmlApplicationContext context = new
                ClassPathXmlApplicationContext("applicationContext.xml");
        World sb = context.getBean("worldBean", World.class);
        System.out.println(sb);

        context.close();
        
    }
}

// Создайте бин класса World. В классе определите конструктор, который принимает название создаваемого мира и
// выводит фразу «Сотворение мира X». Добавьте метод, выводящий в консоль сообщение «Восход цивилизаций».
// Получите бин из контекста и вызовите метод.
// Добавьте метод инициализации, который выводит сообщение «Заселение мира разными существами», и метод
// уничтожения бина, который выводит «Конец Света».
