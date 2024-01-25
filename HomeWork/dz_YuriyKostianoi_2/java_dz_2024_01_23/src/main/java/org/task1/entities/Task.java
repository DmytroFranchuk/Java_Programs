package org.task1.entities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.task1.enums.Priority;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@Scope("prototype")
public class Task implements Comparable<Task> {
    private String title;
    private String description;
    private Priority priority;
    private boolean completed;
    private LocalDateTime startDate;
    private LocalDateTime expirationDate;

    public Task(
            @Value("${task.default.title}") String title,
            @Value("${task.default.description}") String description,
            @Value("${task.default.priority}") Priority priority,
            @Value("${task.default.completed}") boolean completed,
            @Value("${task.default.startDate}") LocalDateTime startDate,
            @Value("${task.default.expirationDate}") LocalDateTime expirationDate)
    {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.completed = completed;
        this.startDate = startDate;
        this.expirationDate = expirationDate;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Priority getPriority() {
        return priority;
    }

    public boolean isCompleted() {
        return completed;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                ", completed=" + completed +
                ", startDate=" + startDate.format(formatter) +
                ", expirationDate=" + expirationDate.format(formatter) +
                '}';
    }

    @Override
    public int compareTo(Task o) {
        return this.priority.compareTo(o.getPriority());
    }
}
