package com.project.todo.services;


import com.project.todo.dao.TodoRepository;
import com.project.todo.dao.UtilisateurRepository;
import com.project.todo.dto.TodoRequest;
import com.project.todo.dto.TodoResponse;
import com.project.todo.entity.Todo;
import com.project.todo.entity.Utilisateur;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    TodoRepository todoRepository;
    @Autowired
    UtilisateurRepository userRepository;
    ModelMapper modelMapper=new ModelMapper();
    public TodoResponse updateTodo(TodoRequest todoRequest, int id){
        Todo todo=todoRepository.findById(id).orElse(null);
        assert todo != null;
        todo.setContent(todoRequest.getContent());
        todo.setCompleted(todoRequest.isCompleted());
        TodoResponse todoResponse=modelMapper.map(todoRepository.save(todo),TodoResponse.class);
        return  todoResponse;
    }
    public void deletTodo(int id){todoRepository.deleteById(id);}
    public TodoResponse addTodo(int id,TodoRequest todoRequest){
        Todo todo=modelMapper.map(todoRequest,Todo.class);
        Utilisateur user=userRepository.findById(id).orElse(null);
        todo.setUtilisateur(user);
        TodoResponse todoResponse=modelMapper.map(todoRepository.save(todo),TodoResponse.class);
        todoResponse.setUser_id(id);
        return  todoResponse;
    }
}
