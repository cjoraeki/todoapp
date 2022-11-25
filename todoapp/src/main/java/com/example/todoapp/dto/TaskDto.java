package com.example.todoapp.dto;

import com.example.todoapp.entity.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {

    private Long user_id;
    private Long taskId;
    private String task_title;
    private String taskStatus;
    private String task_description;
    private LocalTime created_time;
    private LocalTime updated_time;
    private LocalTime completed_time;
    private Set<Task> tasks;
}
