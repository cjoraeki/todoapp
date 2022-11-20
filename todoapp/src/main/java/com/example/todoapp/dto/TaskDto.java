package com.example.todoapp.dto;

import lombok.Data;
import java.time.LocalTime;


@Data
public class TaskDto {

    private Long user_id;
    private Long task_id;
    private String task_title;
    private String task_status;
    private String task_description;
    private LocalTime created_time;
    private LocalTime updated_time;
    private LocalTime completed_time;
}
