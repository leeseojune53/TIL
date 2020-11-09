package com.example.board.Payload.Response;

import com.example.board.Entity.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class WriteResponse {
    private final Board board;
}
