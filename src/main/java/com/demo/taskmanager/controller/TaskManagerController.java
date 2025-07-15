package com.demo.taskmanager.controller;

import com.demo.taskmanager.model.TaskManager;
import com.demo.taskmanager.service.TaskManagerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tasks")
public class TaskManagerController {

    @Autowired
    private TaskManagerService service;

    @PostMapping
    public ResponseEntity<TaskManager> create(@Valid @RequestBody TaskManager task){
        return new ResponseEntity<>(service.createTask(task), HttpStatus.CREATED);
    }

    @GetMapping
    public List<TaskManager> getTaskList(){
        return service.getAllTasks();
    }

    @PostMapping("/{id}")
    public ResponseEntity<TaskManager> updateTask(@PathVariable UUID id, @Valid @RequestBody TaskManager task) {
        return ResponseEntity.ok(service.UpdateTaskStatus(id, task));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        System.out.println("id" + id);
        service.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
