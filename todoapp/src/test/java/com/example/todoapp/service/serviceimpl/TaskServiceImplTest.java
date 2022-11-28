package com.example.todoapp.service.serviceimpl;

import com.example.todoapp.dto.TaskDto;
import com.example.todoapp.entity.Task;
import com.example.todoapp.repository.TaskRepository;
import com.example.todoapp.service.TaskService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class TaskServiceImplTest {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private TaskService taskService;

    @AfterEach
    void tearDown() {
    }

    @Test
    void createTask() {
        var taskDto = new TaskDto();
        taskDto.setUser_id(1L);
        taskDto.setTaskStatus("PENDING");
        taskDto.setTask_title("Noise");
        taskDto.setTask_description("Empty containers making loudest noise");
        taskDto.setCreated_time(LocalTime.now());


        Task taskCreate = taskService.createTask(taskDto);
        assertEquals(taskDto.getTask_title(), taskCreate.getTask_title());
    }



    @Test
    void completedTask() {
    }

    @Test
    void editTaskTitle() {
    }

    @Test
    void editTaskDescription() {
    }

    @Test
    void returnTaskFromCompletedToPending() {
    }

    @Test
    void deleteTask() {
    }

    @Test
    void getAllTasks() {
    }

    @Test
    void viewAllPendingTasks() {
    }

    @Test
    void viewAllDoneTasks() {
    }
}