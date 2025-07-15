package com.demo.taskmanager.repository;

import com.demo.taskmanager.model.TaskManager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskManagerRepository extends JpaRepository<TaskManager, UUID> {
}
