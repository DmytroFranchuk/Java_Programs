package org.lesson.springExample.task1_threads;

import org.springframework.context.support.ClassPathXmlApplicationContext;

// Создайте Spring-приложение, которое использует бины класса ImmediateThread.
// Перед созданием бина ImmediateThread создаёт поток из бина типа Runnable.
// На стадии создания бина ImmediateThread запускает поток.
// На стадии уничтожения бина поток помечается для прерывания.
// Сопроводите все этапы соответствующими сообщениями в консоль.
// Создайте бин ImmediateThread с областью видимости singleton и выполните программу.
// Затем измените scope на prototype и выполните программу повторно. Что изменилось?
public class App {
    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ImmediateThread immediateThread = context.getBean("immediateThread", ImmediateThread.class);
        System.out.println(immediateThread.getId());
        immediateThread.join();
        context.close();
    }
}

