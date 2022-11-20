package com.example.todoapp.service;

import com.example.todoapp.dto.TaskDto;
import com.example.todoapp.entity.Task;

public interface TaskService {

    Task createTask(TaskDto taskDto);

    void deleteTask(TaskDto taskDto);

    Task editTask(TaskDto taskDto);

    Task completedTask(TaskDto taskDto);

}
