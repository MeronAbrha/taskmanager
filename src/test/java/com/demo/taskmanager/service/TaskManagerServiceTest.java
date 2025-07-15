package com.demo.taskmanager.service;

import com.demo.taskmanager.enums.TaskStatus;
import com.demo.taskmanager.model.TaskManager;
import com.demo.taskmanager.repository.TaskManagerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TaskManagerServiceTest {

    @Mock
    TaskManagerRepository repository;

    @InjectMocks
    TaskManagerService service;

    @Test
    void testCreateTaskManager() {
        TaskManager input = new TaskManager(null, "Excersise", "Every morning before breakfast" , TaskStatus.TODO);
        TaskManager saved = new TaskManager(UUID.randomUUID(), "Excersise" , "Every morning before breakfast", TaskStatus.TODO);

        when(repository.save(input)).thenReturn(saved);
        assertEquals(saved, service.createTask(input));
    }


}
