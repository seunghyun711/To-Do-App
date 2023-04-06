package com.soloProject.ToDoApp.todo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
public class TodoDto {
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class Post{

        @Valid
        @NotNull(message = "할 일을 입력하세요.")
        private String title;

//        @Valid
//        @NotNull(message = "우선 순위를 입력하세요.")
//        private int orders;

        @Valid
        @NotNull(message = "진행 여부를 입력하세요(true/false")
        private boolean completed;

        public void setTitle(String title) {
            this.title = title;
        }

//        public void setTodoOrder(int orders) {
//            this.orders = orders;
//        }

        public void setCompleted(boolean completed) {
            this.completed = completed;
        }
    }

    @Getter
    @AllArgsConstructor
    public static class Response{
        @Positive
        private long id;
        private String title;
        private int orders;
        private boolean completed;

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

}
