package org.task1.entities.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.task1.entities.Task;
import org.task1.enums.Priority;

import java.util.ArrayList;
import java.util.List;

@Component
public class ToDoList {
    private List<Task> tasks;

    @Value("${taskList.default.size}")
    private int size;

    public ToDoList() {
        this.tasks = new ArrayList<>(size);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        if (tasks.size() >= size) {
            throw new IllegalArgumentException("Список задач заполнен");
        }
        tasks.add(task);
    }

    public void removeTask(Task task) {
        if (!tasks.isEmpty()) {
            tasks.remove(task);
        }
    }

    public void markTaskAsCompleted(Task task) {
        task.setCompleted(true);
    }

    public void sendNotifications(NotificationService notificationService) {
        for (Task task : tasks) {
            if (task.getPriority() == Priority.HIGH) {
                notificationService.sendNotification(task);
            }
        }
    }
}
