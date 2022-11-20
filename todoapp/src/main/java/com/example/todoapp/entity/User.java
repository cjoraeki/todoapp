package com.example.todoapp.entity;

import lombok.*;
import javax.persistence.*;



@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column(length = 20)
    private String firstname;

    @Column(length = 20)
    private String surname;

    @Column(length = 40, unique=true)
    private String email;

    @Column(length = 10)
    private String password;

}
