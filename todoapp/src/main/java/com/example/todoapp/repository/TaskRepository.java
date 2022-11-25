package com.example.todoapp.repository;

import com.example.todoapp.dto.TaskDto;
import com.example.todoapp.entity.Task;
import com.example.todoapp.entity.User;
import org.aspectj.apache.bcel.generic.LineNumberGen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {


    Optional<List<Task>> findAllByUser(User user);
    Optional<List<Task>> findTasksByTaskStatus(String taskStatus);


    //    @Override
//    List<Task> findTasksByTask_id(Long task_id);
}
