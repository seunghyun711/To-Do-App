package com.soloProject.ToDoApp.exception;

import lombok.Getter;

// 에러 관련 메시지
public enum ExceptionCode {
    TITLE_EXISTS(404,"THIS TITLE IS ALREADY EXISTED"), // 이미 존재하는 할일인 경우
    ORDERS_EXISTS(404,"THIS TODO_ORDER IS ALREADY EXISTED"), // 우선순위가 겹치는 경우
    ID_NOT_FOUND(404, "THIS ID DOES NOT EXIST"); // 존재하지 않는 id인 경우

    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
