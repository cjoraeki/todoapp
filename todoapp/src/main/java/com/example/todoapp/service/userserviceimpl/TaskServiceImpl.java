package com.example.todoapp.service.userserviceimpl;

import com.example.todoapp.dto.TaskDto;
import com.example.todoapp.entity.Task;
import com.example.todoapp.entity.User;
import com.example.todoapp.enums.TaskStatus;
import com.example.todoapp.repository.TaskRepository;
import com.example.todoapp.repository.UserRepository;
import com.example.todoapp.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public Task createTask(TaskDto taskDto) {
        User user = new User();
        user.setUserId(taskDto.getUser_id());
        Task task = new Task();
        task.setTaskId(taskDto.getTaskId());
        task.setTask_title(taskDto.getTask_title());
        task.setTask_description(taskDto.getTask_description());
        task.setTaskStatus(TaskStatus.PENDING.name());
        task.setUser(user);

        return taskRepository.save(task);
    }

    @Override
    public Task completedTask(TaskDto taskDto) {
        User user = new User();
        user.setUserId(taskDto.getUser_id());
        Task task = taskRepository.findById(taskDto.getTaskId()).get();
        task.setCompleted_time(LocalTime.now());
        task.setTaskStatus(TaskStatus.DONE.name());
        task.setUser(user);

        return taskRepository.save(task);
    }


    @Override
    public Task editTaskTitle(TaskDto taskDto) {
        User user = new User();
        user.setUserId(taskDto.getUser_id());
        Task task = taskRepository.findById(taskDto.getTaskId()).get();
        task.setUpdated_time(LocalTime.now());
        task.setTaskStatus(TaskStatus.PENDING.name());
        task.setTask_title(taskDto.getTask_title());
        task.setUser(user);

        return taskRepository.save(task);
    }


    @Override
    public Task editTaskDescription(TaskDto taskDto) {
        User user = new User();
        user.setUserId(taskDto.getUser_id());
        Task task = taskRepository.findById(taskDto.getTaskId()).get();
        task.setUpdated_time(LocalTime.now());
        task.setTaskStatus(TaskStatus.PENDING.name());
        task.setTask_description(taskDto.getTask_description());
        task.setUser(user);

        return taskRepository.save(task);
    }


    @Override
    public Task returnTaskFromCompletedToPending(TaskDto taskDto) {
        User user = new User();
        user.setUserId(taskDto.getUser_id());
        Task task = taskRepository.findById(taskDto.getTaskId()).get();
        task.setCompleted_time(null);
        task.setTaskStatus(TaskStatus.PENDING.name());
        task.setUser(user);

        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(TaskDto taskDto) {
        taskRepository.deleteById(taskDto.getTaskId());
    }


    @Override
    public List<TaskDto> getAllTasks(Long user_id) {
        User user = new User();
        user.setUserId(user_id);
        List<Task> tasks = taskRepository.findAllByUser(user).orElse(null);

        List<TaskDto> taskDtos = new ArrayList<>();
        tasks.stream().forEach(task -> {
            TaskDto taskDto = new TaskDto();
            BeanUtils.copyProperties(task, taskDto);
            taskDtos.add(taskDto);
        });
        return taskDtos;
    }


    @Override
    public List<TaskDto> viewAllPendingTasks(String taskStatus) {

        Task task = new Task();
        task.setTaskStatus(taskStatus);
        List<Task> tasks = taskRepository.findTasksByTaskStatus(taskStatus).orElse(null);

        List<TaskDto> taskDtos = new ArrayList<>();
        tasks.stream().forEach(task1 -> {
            TaskDto taskDto = new TaskDto();
            BeanUtils.copyProperties(task1, taskDto);
            taskDtos.add(taskDto);
        });
        return taskDtos;

    }


    @Override
    public List<TaskDto> viewAllDoneTasks(String taskStatus) {

        Task task = new Task();
        task.setTaskStatus(taskStatus);
        List<Task> tasks = taskRepository.findTasksByTaskStatus(taskStatus).orElse(null);

        List<TaskDto> taskDtos = new ArrayList<>();
        tasks.stream().forEach(task1 -> {
            TaskDto taskDto = new TaskDto();
            BeanUtils.copyProperties(task1, taskDto);
            taskDtos.add(taskDto);
        });

        return taskDtos;
    }

}


