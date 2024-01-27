package org.task1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.task1.config.Config;
import org.task1.entities.Task;
import org.task1.entities.service.NotificationService;
import org.task1.entities.service.ToDoList;
import org.task1.enums.Priority;

import java.util.Comparator;

public class MainApp1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        ToDoList taskList = context.getBean(ToDoList.class);

        Task task1 = context.getBean(Task.class);
        task1.setTitle("Task 1");
        task1.setPriority(Priority.MEDIUM);

        Task task2 = context.getBean(Task.class);
        task2.setTitle("Task 2");
        task2.setPriority(Priority.HIGH);

        Task task3 = context.getBean(Task.class);
        task3.setTitle("Task 3");
        task3.setPriority(Priority.HIGH);

        taskList.addTask(task1);
        taskList.addTask(task2);
        taskList.addTask(task3);

        taskList.getTasks().sort(Comparator.comparing(Task::getPriority).reversed());
        taskList.getTasks().forEach(System.out::println);

        taskList.sendNotifications(context.getBean("push", NotificationService.class));
//        taskList.sendNotifications(context.getBean("email", NotificationService.class));
//        taskList.sendNotifications(context.getBean(NotificationService.class));
    }
}
