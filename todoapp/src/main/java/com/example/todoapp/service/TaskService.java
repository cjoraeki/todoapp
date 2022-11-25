package com.example.todoapp.service;

import com.example.todoapp.dto.TaskDto;
import com.example.todoapp.entity.Task;
import java.util.List;


public interface TaskService {

    Task createTask(TaskDto taskDto);

    void deleteTask(TaskDto taskDto);

    Task editTaskTitle(TaskDto taskDto);

    Task editTaskDescription(TaskDto taskDto);

    Task returnTaskFromCompletedToPending(TaskDto taskDto);

    Task completedTask(TaskDto taskDto);

    List<TaskDto> getAllTasks(Long user_id);

    List<TaskDto> viewAllDoneTasks(String taskStatus);

    List<TaskDto> viewAllPendingTasks(String taskStatus);

}
