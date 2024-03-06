package com.nchdatta.SchoolManagementSystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, length = 45, nullable = false)
    private String username;

    @Column(length = 150, nullable = false)
    private String password;

    private String name;

    @Column(unique = true, length = 255, nullable = false)
    private String email;

    private String role;

}
