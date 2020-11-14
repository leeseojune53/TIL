package com.example.board.Service.Comment;

import com.example.board.Payload.Request.CommentRequest;
import com.example.board.Payload.Response.CommentResponse;

public interface CommentService {
    public CommentResponse writeComment(CommentRequest request);
}
