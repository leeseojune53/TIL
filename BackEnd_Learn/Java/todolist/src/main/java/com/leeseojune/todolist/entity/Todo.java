package com.leeseojune.todolist.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "todo")
public class Todo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer todoId;

    private String content;

    private boolean isCheck;

    public Todo changeCheck(){
        this.isCheck = !isCheck;
        return this;
    }

}
