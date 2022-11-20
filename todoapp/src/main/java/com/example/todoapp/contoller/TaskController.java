package com.example.todoapp.contoller;


import com.example.todoapp.dto.TaskDto;
import com.example.todoapp.entity.Task;
import com.example.todoapp.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/create")
    public ResponseEntity<String> toCreateTask(@RequestBody TaskDto taskDto){
        taskService.createTask(taskDto);
        return new ResponseEntity<>("Task created", HttpStatus.CREATED);
    }

    @PatchMapping("/completed")
    public ResponseEntity<String> toCompleteTask(@RequestBody TaskDto taskDto){
        taskService.completedTask(taskDto);
        return new ResponseEntity<>("Task completed", HttpStatus.OK);
    }

    @PatchMapping("/edit")
    public ResponseEntity<String> toEditTask(@RequestBody TaskDto taskDto){
        taskService.editTask(taskDto);
        return new ResponseEntity<>("Edit successful", HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> toDeleteTask(@RequestBody TaskDto taskDto){
        taskService.deleteTask(taskDto);
        return new ResponseEntity<>("Task deleted", HttpStatus.OK);
    }

}
