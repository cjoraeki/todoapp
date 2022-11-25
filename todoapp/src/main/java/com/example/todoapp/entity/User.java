package com.example.todoapp.entity;

import lombok.*;
import javax.persistence.*;
import java.util.Set;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    ////make user_id id

    @Column(length = 20)
    private String firstname;

    @Column(length = 20)
    private String surname;

    @Column(length = 40, unique=true)
    private String email;

    @Column(length = 10)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Task> tasks;

}
