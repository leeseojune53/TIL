package com.example.board.Service.Write;

import com.example.board.Entity.Board.Board;
import com.example.board.Entity.Board.BoardRepository;
import com.example.board.Exception.WriteException;
import com.example.board.Payload.Request.ModifyRequest;
import com.example.board.Payload.Request.WriteRequest;
import com.example.board.Payload.Response.WriteResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class WriteServiceImpl implements WriteService{
    private final BoardRepository boardRepository;
    @Override
    public WriteResponse Write(WriteRequest request) {
        try{
            Board board = Board.builder()
                    .title(request.getTitle())
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
    public WriteResponse Modify(ModifyRequest request) {
        return boardRepository.findById(request.getId())
                .map(board -> {
                    board.setTitle(request.getTitle());
                    board.setContents(request.getContents());
                    board.setModifyAt(new Date());
                    boardRepository.save(board);
                    return new WriteResponse(board);
                })
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public WriteResponse content(int id) {
        return boardRepository.findById(id)
                .map(WriteResponse::new)
                .orElseThrow(RuntimeException::new);
    }


}
