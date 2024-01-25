package org.task1.entities.service;

import org.springframework.stereotype.Component;
import org.task1.entities.Task;

@Component
public interface NotificationService {
    void sendNotification(Task task);
}
