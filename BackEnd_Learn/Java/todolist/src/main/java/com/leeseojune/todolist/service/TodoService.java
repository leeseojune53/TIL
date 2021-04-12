package com.leeseojune.todolist.service;

import com.leeseojune.todolist.dto.TodoDTO;

import java.util.List;

public interface TodoService {
    List<TodoDTO.Todo> getAll();
    void addTodo(TodoDTO.Add request);
    void check(int todoId);
    void delete(int todoId);
    void modify(TodoDTO.Modify request, int todoId);
}
