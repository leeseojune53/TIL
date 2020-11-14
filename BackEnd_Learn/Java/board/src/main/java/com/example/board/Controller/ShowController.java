package com.example.board.Controller;

import com.example.board.Entity.Board.Board;
import com.example.board.Entity.Comment.Comment;
import com.example.board.Payload.Response.ShowResponse;
import com.example.board.Payload.Response.WriteResponse;
import com.example.board.Service.Show.ShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/show")
public class ShowController {
    private final ShowService showService;

    @GetMapping("/list")
    public List<ShowResponse> showList(){
        return showService.showList();
    }

    @GetMapping("/all")
    public List<Board> showAll(){
        return showService.showAll();
    }

    @GetMapping("/{id}")
    public WriteResponse showWrite(@PathVariable("id") int id){
        return showService.showWrite(id);
    }

    @GetMapping("/comment/{id}")
    public List<Comment> showComment(@PathVariable("id") int id){
        return showService.showComment(id);
    }
}
