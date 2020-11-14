package com.example.board.Service.Show;

import com.example.board.Entity.Board.Board;
import com.example.board.Entity.Board.BoardRepository;
import com.example.board.Entity.Comment.Comment;
import com.example.board.Entity.Comment.CommentRepository;
import com.example.board.Payload.Response.ShowResponse;
import com.example.board.Payload.Response.WriteResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowServiceImpl implements ShowService{
    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

    @Override
    public List<ShowResponse> showList() {
        List<ShowResponse> responseList = new ArrayList<>();
        List<Board> list = boardRepository.findTop10ByOrderByCreateAtDesc();
        for (Board b:list) {
            responseList.add(new ShowResponse(b.getId(), b.getTitle(), b.getAuthor(), b.getCreateAt()));
        }
        return responseList;
    }

    @Override
    public List<Board> showAll() {
        return boardRepository.findAll();
    }

    @Override
    public WriteResponse showWrite(int id) {
        return boardRepository.findById(id)
                .map(board -> {
                    board.setViews(board.getViews()+1);
                    boardRepository.save(board);
                    return new WriteResponse(board);
                })
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Comment> showComment(int id) {
        return boardRepository.findById(id).get().getComments();
    }


}
