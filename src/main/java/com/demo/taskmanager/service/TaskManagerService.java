package com.demo.taskmanager.service;


import com.demo.taskmanager.enums.TaskStatus;
import com.demo.taskmanager.model.TaskManager;
import com.demo.taskmanager.repository.TaskManagerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskManagerService {

    @Autowired
    private TaskManagerRepository repository;

    public TaskManager createTask(TaskManager task){
        task.setId(null);
        return repository.save(task);
    }

    public List<TaskManager> getAllTasks(){
        return repository.findAll();
    }

    public TaskManager UpdateTaskStatus(UUID id, TaskStatus newStatus){
        TaskManager task = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setStatus(newStatus);
        return repository.save(task);
    }

//    public TaskManager UpdateTaskStatus(UUID id, TaskManager task){
//        TaskManager updateTask = repository.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException("Task not found"));
//        updateTask.setTitle(task.getTitle());
//        updateTask.setDescription(task.getDescription());
//        updateTask.setStatus(task.getStatus());
//        return repository.save(updateTask);
//    }

    public void deleteTask(UUID id){
        repository.deleteById(id);
    }
}
