package com.leeseojune.todolist.dto;

import com.leeseojune.todolist.entity.Todo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class TodoDTO {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Add{
        private String content;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Todo{
        private String content;
        private boolean isCheck;

        public Todo(com.leeseojune.todolist.entity.Todo todo){
            this.content = todo.getContent();
            this.isCheck = todo.isCheck();
        }

    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Modify{
        private String content;
    }

}
