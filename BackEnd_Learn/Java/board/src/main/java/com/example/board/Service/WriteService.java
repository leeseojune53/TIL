package com.example.board.Service;

import com.example.board.Entity.Board;
import com.example.board.Payload.Request.WriteRequest;
import com.example.board.Payload.Response.WriteResponse;

import java.util.List;

public interface WriteService {
    WriteResponse Write(WriteRequest request);
    List<Board> show();
}
