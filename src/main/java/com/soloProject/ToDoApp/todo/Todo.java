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
    private int orders; // 순서

    @Column(nullable = false)
    private boolean completed; // 진행 여부

    public void setTitle(String title) {
        this.title = title;
    }

    public void setOrders(int orders) {
        this.orders = orders;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
