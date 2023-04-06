package com.soloProject.ToDoApp.todo;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TodoMapper {
    // TodoDto.Post -> Todo
    Todo todoDtoPostDtoToTodo(TodoDto.Post post);

    List<TodoDto.Response> todoToTodoResponse(List<Todo> todos);
}
