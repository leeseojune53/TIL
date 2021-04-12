package com.leeseojune.todolist.controller;

import com.leeseojune.todolist.dto.TodoDTO;
import com.leeseojune.todolist.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping("/post")
    public void addTodo(@RequestBody TodoDTO.Add request){
        todoService.addTodo(request);
    }

    @DeleteMapping("/remove")
    public void delete(@PathParam("id") int id) {
        todoService.delete(id);
    }

    @PatchMapping("/check")
    public void check(@PathParam("id") int id) {
        todoService.check(id);
    }

    @GetMapping("/todo")
    public List<TodoDTO.Todo> getAll() {
        return todoService.getAll();
    }

}
