package com.example.todoapp.service.userserviceimpl;

import com.example.todoapp.dto.TaskDto;
import com.example.todoapp.entity.Task;
import com.example.todoapp.entity.User;
import com.example.todoapp.enums.TaskStatus;
import com.example.todoapp.repository.TaskRepository;
import com.example.todoapp.service.TaskService;
import com.fasterxml.jackson.databind.util.BeanUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public Task createTask(TaskDto taskDto) {
        Task task = new Task();
        User user = new User();
        user.setUser_id(taskDto.getUser_id());
        task.setTask_title(taskDto.getTask_title());
        task.setTask_description(taskDto.getTask_description());
        task.setTask_status(TaskStatus.PENDING.name());

        return taskRepository.save(task);
    }

    @Override
    public Task completedTask(TaskDto taskDto){
        Task task = taskRepository.findById(taskDto.getTask_id()).get();
        task.setCompleted_time(LocalTime.now());
        task.setTask_status(TaskStatus.DONE.name());
        task.setTask_title(taskDto.getTask_title());
        task.setTask_description(taskDto.getTask_description());

        return taskRepository.save(task);
    }

    @Override
    public Task editTask(TaskDto taskDto) {
        Task task = taskRepository.findById(taskDto.getTask_id()).get();
        task.setUpdated_time(LocalTime.now());
        task.setTask_status(TaskStatus.PENDING.name());
        task.setTask_title(taskDto.getTask_title());
        task.setTask_description(taskDto.getTask_description());

        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(TaskDto taskDto) {
        taskRepository.deleteById(taskDto.getTask_id());
    }



}
