package org.task1.entities.impl;

import org.springframework.stereotype.Component;
import org.task1.entities.Task;
import org.task1.entities.service.NotificationService;

@Component("email")
public class EmailNotificationService implements NotificationService {

    @Override
    public void sendNotification(Task task) {
        System.out.printf("Уведомление через Email-сервис: задачa %s имеет приоритет %s%n", task.getTitle(), task.getPriority());
    }
}
