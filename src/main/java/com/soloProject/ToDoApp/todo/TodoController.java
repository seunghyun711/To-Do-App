package com.soloProject.ToDoApp.todo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@CrossOrigin
@RestController
@RequestMapping("/todo")
@Validated
public class TodoController {
    private final static String MEMBER_DEFAULT_URL = "/todo";
    private final TodoService todoService;
    private final TodoMapper mapper;

    public TodoController(TodoService todoService, TodoMapper mapper) {
        this.todoService = todoService;
        this.mapper = mapper;
    }

    // 할 일 생성
    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody TodoDto.Post post) {
        Todo todo = mapper.todoDtoPostDtoToTodo(post);
        todoService.createTodo(todo);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
