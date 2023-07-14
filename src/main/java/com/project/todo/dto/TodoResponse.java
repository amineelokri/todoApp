package com.project.todo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TodoResponse {
    private int id;
    private String content;
    private  boolean completed;
    private int user_id;
}
