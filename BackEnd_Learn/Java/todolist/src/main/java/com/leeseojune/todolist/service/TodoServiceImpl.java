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
    public List<TodoDTO.Todo> getAll() {
        List<TodoDTO.Todo> result = new ArrayList<>();
        for(Todo todo : todoRepository.findAll()){
            result.add(new TodoDTO.Todo(todo));
        }
        return result;
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
        todoRepository.deleteById(todoId);
    }
}
