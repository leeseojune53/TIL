package com.example.board.Controller;

import com.example.board.Entity.Board;
import com.example.board.Payload.Request.WriteRequest;
import com.example.board.Payload.Response.WriteResponse;
import com.example.board.Service.WriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class WriteController {
    private final WriteService writeService;

    @PostMapping("/write")
    public WriteResponse write(@RequestBody WriteRequest request){
        return writeService.Write(request);
    }

    @GetMapping("/show")
    public List<Board> show(){
        return writeService.show();
    }
}
