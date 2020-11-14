package com.example.board.Service.Show;

import com.example.board.Entity.Board.Board;
import com.example.board.Entity.Comment.Comment;
import com.example.board.Payload.Response.ShowResponse;
import com.example.board.Payload.Response.WriteResponse;

import java.util.List;

public interface ShowService {
    public List<ShowResponse> showList();
    public List<Board> showAll();
    public WriteResponse showWrite(int id);
    public List<Comment> showComment(int id);
}
