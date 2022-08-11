package com.example.tasktracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor @Data
public class Task {
    private int id;
    private String title;
    private String description;
    private String status;
    private String deadline;
}
