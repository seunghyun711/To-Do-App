package com.soloProject.ToDoApp.todo;

import com.soloProject.ToDoApp.exception.BusinessLogicException;
import com.soloProject.ToDoApp.exception.ExceptionCode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
    1. 중복 title 검증
     */
    public Todo createTodo(Todo todo) {
        verifyExistsTitle(todo);
        return todoRepository.save(todo);
    }

    /*
    <To-do List 조회>
    1. id 검증(존재하는 id 인지)
     */
    public Page<Todo> findTodos(long id, int page, int size) {
        // 1. id 검증
        verifyTodo(id);

        return todoRepository.findAll(PageRequest.of(page, size, Sort.by("orders").descending()));
    }

    // 중복 title 검증
    private void verifyExistsTitle(Todo todo) {
        String title = todo.getTitle();
        Optional<Todo> optionalTodo = todoRepository.findByTitle(title);
        if (optionalTodo.isPresent()) {
            throw new BusinessLogicException(ExceptionCode.TITLE_EXISTS);
        }
    }

    // id 검증
    private void verifyTodo(long id) {
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        if (!optionalTodo.isPresent()) { // id가 존재하지 않는 경우
            throw new BusinessLogicException(ExceptionCode.ID_NOT_FOUND);
        }
    }
}
