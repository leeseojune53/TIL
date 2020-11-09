package com.example.board.Payload.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class WriteRequest {
    private String name;
    private String contents;
    private String author;


}
