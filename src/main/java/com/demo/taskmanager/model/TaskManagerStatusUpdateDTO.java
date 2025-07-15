package com.demo.taskmanager.model;

import com.demo.taskmanager.enums.TaskStatus;
import jakarta.validation.constraints.NotNull;

public class TaskManagerStatusUpdateDTO {

    @NotNull
    private TaskStatus status;

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }
}
