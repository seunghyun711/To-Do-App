package com.soloProject.ToDoApp.todo;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title; // 해야할 일

    @Column(nullable = false)
    private int todoOrder; // 순서

    @Column(nullable = false)
    private boolean completed; // 진행 여부

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTodoOrder(int todoOrder) {
        this.todoOrder = todoOrder;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
