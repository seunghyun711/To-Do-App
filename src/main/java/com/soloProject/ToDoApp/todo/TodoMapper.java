package com.soloProject.ToDoApp.todo;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TodoMapper {
    // TodoDto.Post -> Todo
    Todo todoDtoPostDtoToTodo(TodoDto.Post post);

    Todo todoDtoPatchDtoToTodo(TodoDto.Patch patch);

    List<TodoDto.Response> todoToTodoResponseDtos(List<Todo> todos);

    TodoDto.Response todoToTodoResponseDto(Todo todo);
}
