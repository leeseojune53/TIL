package com.example.board.Controller;

import com.example.board.Payload.Request.CommentRequest;
import com.example.board.Payload.Response.CommentResponse;
import com.example.board.Service.Comment.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/comment")
    public CommentResponse writeComment(@RequestBody CommentRequest request){
        return commentService.writeComment(request);
    }

}
