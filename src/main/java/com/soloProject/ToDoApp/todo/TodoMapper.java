package com.soloProject.ToDoApp.todo;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TodoMapper {
    // TodoDto.Post -> Todo
    Todo todoDtoPostDtoToTodo(TodoDto.Post post);
}
