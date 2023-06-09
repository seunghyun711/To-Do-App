package com.soloProject.ToDoApp.todo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    Optional<Todo> findByTitle(String title);

    Optional<Todo> findByOrders(int orders);
}
