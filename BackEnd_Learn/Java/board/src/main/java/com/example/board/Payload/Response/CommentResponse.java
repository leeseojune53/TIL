package com.example.board.Payload.Response;

import com.example.board.Entity.Comment.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommentResponse {
    private final Comment comment;
}
