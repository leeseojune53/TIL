package com.example.board.Controller;

import com.example.board.Payload.Request.ModifyRequest;
import com.example.board.Payload.Request.WriteRequest;
import com.example.board.Payload.Response.WriteResponse;
import com.example.board.Service.Write.WriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class WriteController {
    private final WriteService writeService;

    @PostMapping("/write")
    public WriteResponse write(@RequestBody WriteRequest request){
        return writeService.Write(request);
    }

    @PatchMapping("/modify") // 수정
    public WriteResponse modify(@RequestBody ModifyRequest request){
        return writeService.Modify(request);
    }

    @GetMapping("/modify") // 수정할 데이터 가져오기
    public WriteResponse contents(@RequestParam int id){
        return writeService.content(id);
    }


}
