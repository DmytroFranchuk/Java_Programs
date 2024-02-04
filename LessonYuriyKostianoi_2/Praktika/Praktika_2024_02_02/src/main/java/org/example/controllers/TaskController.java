package org.example.controllers;

import org.example.dto.CreateResponse;
import org.example.dto.Task;
import org.example.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class TaskController {


   private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public Map<Long, Task> getTasks(){
        return taskService.getTasks();
    }

    @GetMapping("/tasks/{id}")
    public Task getTask(@PathVariable(name="id") long id){
        return taskService.getTask(id);
    }


    @PostMapping("/tasks")
    public CreateResponse create(@RequestBody Task task){
        return taskService.createTask(task);
    }

    @PutMapping("/tasks/{id}")
    public void update(@PathVariable(name="id") long id,@RequestBody Task task){
        taskService.updateTask(id, task);
    }

    @DeleteMapping("/tasks/{id}")
    public void delete(@PathVariable(name="id") long id){
        taskService.deleteTask(id);
    }

}
//Разработайте RESTful API для управления списком задач. API должно поддерживать операции создания, чтения
// (одной и всех задач), обновления и удаления задач (CRUD).