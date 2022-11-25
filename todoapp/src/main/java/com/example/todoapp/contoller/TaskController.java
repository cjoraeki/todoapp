package com.example.todoapp.contoller;


import com.example.todoapp.dto.TaskDto;
import com.example.todoapp.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/task")
public class TaskController {

    private TaskService taskService;

    @PostMapping("/create")
    public ResponseEntity<String> toCreateTask(@RequestBody TaskDto taskDto){
        taskService.createTask(taskDto);
        return new ResponseEntity<>("Task created", HttpStatus.CREATED);
    }

    @PostMapping("/completed")
    public ResponseEntity<String> toCompleteTask(@RequestBody TaskDto taskDto){
        taskService.completedTask(taskDto);
        return new ResponseEntity<>("Task completed", HttpStatus.OK);
    }

    @PatchMapping("/title")
    public ResponseEntity<String> toEditTaskTitle(@RequestBody TaskDto taskDto){
        taskService.editTaskTitle(taskDto);
        return new ResponseEntity<>("Title edited successfully", HttpStatus.ACCEPTED);
    }

    @PatchMapping("/description")
    public ResponseEntity<String> toEditTaskDescription(@RequestBody TaskDto taskDto){
        taskService.editTaskDescription(taskDto);
        return new ResponseEntity<>("Description edited successfully", HttpStatus.ACCEPTED);
    }

    @PatchMapping("/pending")
    public ResponseEntity<String> toEditTaskFromCompletedToPending(@RequestBody TaskDto taskDto){
        taskService.returnTaskFromCompletedToPending(taskDto);
        return new ResponseEntity<>("Task is pending", HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> toDeleteTask(@RequestBody TaskDto taskDto){
        taskService.deleteTask(taskDto);
        return new ResponseEntity<>("Task deleted", HttpStatus.OK);
    }

    @GetMapping("/viewalltasks/{user_id}")
    public ResponseEntity<List<TaskDto>> toViewAllTasks(@PathVariable Long user_id){
        List<TaskDto> taskList = taskService.getAllTasks(user_id);
        return new ResponseEntity<>(taskList, HttpStatus.FOUND);
    }

    @GetMapping("/viewdone")
    public ResponseEntity <List<TaskDto>> toViewAParticularTask(@RequestBody TaskDto taskDto){
        List<TaskDto> taskList = taskService.viewAllDoneTasks(taskDto.getTaskStatus());
        return new ResponseEntity<>(taskList, HttpStatus.FOUND);
    }


    @GetMapping("/viewpend")
    public ResponseEntity <List<TaskDto>> toViewPendingTask(@RequestBody TaskDto taskDto){
        List<TaskDto> taskList = taskService.viewAllPendingTasks(taskDto.getTaskStatus());
        return new ResponseEntity<>(taskList, HttpStatus.FOUND);
    }
}



