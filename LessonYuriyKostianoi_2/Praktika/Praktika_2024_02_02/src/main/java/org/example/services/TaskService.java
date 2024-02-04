package org.example.services;

import org.example.dto.CreateResponse;
import org.example.dto.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TaskService {
    private Map<Long, Task> tasks;

    private AtomicLong count;
    public TaskService() {
        this.tasks = new HashMap<>();
        this.count = new AtomicLong(0L);
    }

    public Map<Long, Task> getTasks() {
        return new HashMap<>(tasks);
    }

    public Task getTask(long id){
        return tasks.get(id);
    }

    public CreateResponse createTask(Task task){
        long id = count.getAndIncrement();
        tasks.put(id, task);
        return new CreateResponse(id, task);
    }

    public void deleteTask(long id){
        tasks.remove(id);
    }

    public void updateTask(long id, Task task){
        tasks.put(id, task);
    }

}
