package com.example.board.Service;

import com.example.board.Entity.Board;
import com.example.board.Entity.BoardRepository;
import com.example.board.Exception.WriteException;
import com.example.board.Payload.Request.WriteRequest;
import com.example.board.Payload.Response.WriteResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WriteServiceImpl implements WriteService{
    private final BoardRepository boardRepository;
    @Override
    public WriteResponse Write(WriteRequest request) {
        try{
            Board board = Board.builder()
                    .name(request.getName())
                    .contents(request.getContents())
                    .author(request.getAuthor())
                    .build();
            boardRepository.save(board);
            return new WriteResponse(board);
        }catch(Exception e){
            throw new WriteException();
        }
    }

    @Override
    public List<Board> show() {
        return boardRepository.findAll();
    }


}
