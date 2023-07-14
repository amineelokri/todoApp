package com.project.todo.controller;

import com.project.todo.dto.TodoRequest;
import com.project.todo.dto.TodoResponse;
import com.project.todo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    TodoService todoService;

    @PutMapping("/update/{id}")
    public TodoResponse update(@PathVariable int id, @RequestBody TodoRequest todoRequest){
        return  todoService.updateTodo(todoRequest, id);
    }
    @DeleteMapping("/delet/{id}")
    public void delet(@PathVariable int id){
        todoService.deletTodo(id);
    }
    @PostMapping("/add/{id}")
    public TodoResponse add(@PathVariable int id,@RequestBody TodoRequest todoRequest){
        return  todoService.addTodo(id,todoRequest);
    }
}
