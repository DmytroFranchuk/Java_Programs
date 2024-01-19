package org.solution.task2;

import org.solution.task2.scheduler.MessageSenderScheduler;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Solution2 {
    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("appContext1.xml");
        var generator = context.getBean(MessageSenderScheduler.class);
        generator.startSendingMessages(3);
    }
}

// Создайте класс MessageGenerator, который генерирует уникальные сообщения с временной меткой.
// Каждый раз, когда бин запрашивается из контекста, создаётся новый экземпляр MessageGenerator.
// Внедрите этот бин в классы EmailSender и SmsSender.
