package com.example.demo.Model;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(length = 50, nullable = false)
    private String userName;

    private String password;

    private String email;

    private



}
