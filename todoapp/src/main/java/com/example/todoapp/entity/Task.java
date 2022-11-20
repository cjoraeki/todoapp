package com.example.todoapp.entity;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.time.LocalTime;


@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long task_id;

    private String task_title;

    @Column(length = 500)
    private String task_description;

    private String task_status;

    @CreationTimestamp
    private LocalTime created_time;

    private LocalTime updated_time;

    private LocalTime completed_time;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
