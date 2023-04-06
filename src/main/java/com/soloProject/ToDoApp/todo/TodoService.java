package com.soloProject.ToDoApp.todo;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    /*
    <할 일 생성>
     */
    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }
}
