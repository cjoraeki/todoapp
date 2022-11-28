package com.example.todoapp.repository;

import com.example.todoapp.entity.Task;
import com.example.todoapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    Optional<List<Task>> findAllByUser(User user);
    Optional<List<Task>> findTasksByTaskStatus(String taskStatus);

}
