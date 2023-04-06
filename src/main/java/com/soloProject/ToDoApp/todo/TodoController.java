package com.soloProject.ToDoApp.todo;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/todo")
@Validated
public class TodoController {
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

    // To-Do 수정
    @PatchMapping("/{id}")
    public ResponseEntity patchTodo(@Positive @PathVariable("id") long id,
                                    @Valid @RequestBody TodoDto.Patch patch) {

        Todo todo = mapper.todoDtoPatchDtoToTodo(patch);
        todoService.updateTodo(todo,id);
        return new ResponseEntity<>(mapper.todoToTodoResponseDto(todo), HttpStatus.OK);
    }

    // To-Do list 조회
    @GetMapping
    public ResponseEntity getTodos(@Positive @RequestParam long id,
                                   @Positive @RequestParam int page,
                                   @Positive @RequestParam int size) {
        Page<Todo> todoPage = todoService.findTodos(id, page - 1, size);
        List<Todo> todos = todoPage.getContent();
        return new ResponseEntity<>(mapper.todoToTodoResponseDtos(todos), HttpStatus.OK);
    }

    // To-Do 단건 조회
    @GetMapping("/{id}")
    public ResponseEntity getTodo(@PathVariable("id") @Positive long id) {
        Todo todo = todoService.findTodo(id);

        return new ResponseEntity<>(mapper.todoToTodoResponseDto(todo), HttpStatus.OK);
    }

    // To-Do 전체 삭제
    @DeleteMapping
    public ResponseEntity deleteTodos() {
        todoService.deleteTodos();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
