package com.example.todoapp.entity;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.time.LocalTime;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long taskId;

    private String task_title;

    @Column(length = 500)
    private String task_description;

    private String taskStatus;

    @CreationTimestamp
    private LocalTime created_time;

    private LocalTime updated_time;

    private LocalTime completed_time;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

}
