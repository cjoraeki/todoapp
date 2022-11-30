package com.example.todoapp.contoller;

import com.example.todoapp.dto.TaskDto;
import com.example.todoapp.service.TaskService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = TaskController.class)
class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private TaskService taskService;

    @Test
    void toCreateTask() throws Exception {

            TaskDto taskDto = new TaskDto();
            taskDto.setUser_id(1L);
            taskDto.setTask_title("no arguments");
            taskDto.setTask_description("actual and formal argument lists differ in length");
            taskDto.setCreated_time(LocalTime.now());

            String requestBody = objectMapper.writeValueAsString(taskDto);
            mockMvc.perform(MockMvcRequestBuilders.post("/task/create",201)
                            .contentType("application/json")
                            .content(requestBody))
                    .andExpect(status().isCreated());

    }

    @Test
    void toCompleteTask() {
    }

    @Test
    void toEditTaskTitle() {
    }

    @Test
    void toEditTaskDescription() {
    }

    @Test
    void toEditTaskFromCompletedToPending() {
    }

    @Test
    void toDeleteTask() {
    }

    @Test
    void toViewAllTasks() {
    }

    @Test
    void toViewAParticularTask() {
    }

    @Test
    void toViewPendingTask() {
    }
}