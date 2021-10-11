package com.example.courseregistrationapp;

import java.io.Serializable;

public class User implements Serializable {
    String name;
    String email;
    int id;
    String department;

    public User(String name, String email, int id, String department) {
        this.name = name;
        this.email = email;
        this.id = id;
        this.department = department;
    }

    public User() {
    }
}
