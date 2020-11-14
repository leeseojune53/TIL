package com.example.board.Service.Comment;

import com.example.board.Entity.Board.Board;
import com.example.board.Entity.Board.BoardRepository;
import com.example.board.Entity.Comment.Comment;
import com.example.board.Entity.Comment.CommentRepository;
import com.example.board.Exception.BoardNotExistExcepion;
import com.example.board.Payload.Request.CommentRequest;
import com.example.board.Payload.Response.CommentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{
    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

    @Override
    public CommentResponse writeComment(CommentRequest request) {
        return boardRepository.findById(request.getBoardId())
                .map(board -> {
                    Comment comment = Comment.builder()
                                .userId(request.getUserId())
                                .comment(request.getComment())
                                .board(board)
                            .build();
                    commentRepository.save(comment);
                    return new CommentResponse(comment);
                })
                .orElseThrow(BoardNotExistExcepion::new);
    }
}
