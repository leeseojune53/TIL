package com.example.board.Service.Write;

import com.example.board.Payload.Request.ModifyRequest;
import com.example.board.Payload.Request.WriteRequest;
import com.example.board.Payload.Response.WriteResponse;

public interface WriteService {
    WriteResponse Write(WriteRequest request);
    WriteResponse Modify(ModifyRequest request);
    WriteResponse content(int id);
}
