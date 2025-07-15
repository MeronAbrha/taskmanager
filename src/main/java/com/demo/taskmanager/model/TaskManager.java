package com.demo.taskmanager.model;


import com.demo.taskmanager.enums.TaskStatus;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TaskManager {

    @Id
    @GeneratedValue
    private UUID id;

//    @NotBlank(message = "Title must not be blank")
    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    public TaskManager(Object o, String excersise, String everyMorningBeforeBreakfast, TaskStatus taskStatus) {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }
}
