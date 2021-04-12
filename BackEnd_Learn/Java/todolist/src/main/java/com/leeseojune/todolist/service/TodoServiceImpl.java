package com.leeseojune.todolist.service;

import com.leeseojune.todolist.dto.TodoDTO;
import com.leeseojune.todolist.entity.Todo;
import com.leeseojune.todolist.entity.TodoRepository;
import com.leeseojune.todolist.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{

    private final TodoRepository todoRepository;

    @Override
    public Iterable<Todo> getAll() {
        return todoRepository.findAll();
    }

    @Override
    public void addTodo(TodoDTO.Add request) {
        todoRepository.save(
                Todo.builder()
                .content(request.getContent())
                .isCheck(false)
                .build()
        );
    }

    @Override
    public void check(int todoId) {
        todoRepository.save(
                todoRepository.findById(todoId).orElseThrow(NotFoundException::new).changeCheck()
        );
    }

    @Override
    public void delete(int todoId) {
        todoRepository.delete(todoRepository.findById(todoId).orElseThrow(NotFoundException::new));
    }

    @Override
    public void modify(TodoDTO.Modify request, int todoId) {
        todoRepository.save(
                todoRepository.findById(todoId).orElseThrow(NotFoundException::new).changeContent(request.getContent())
        );
    }
}
