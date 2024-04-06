package com.example.demo.model;

import lombok.Data;

@Data
public class User {
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
}