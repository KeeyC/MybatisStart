package com.example.User;


import lombok.Data;

import java.sql.Timestamp;

@Data
public class Student {
    private Long id;
    private String name;
    private int age;
    private String address;
    private Timestamp creat_time;
}
