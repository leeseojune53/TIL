package com.example.board.Payload.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class ShowResponse {
    private final int id;
    private final String title;
    private final String author;
    private final Date creatAt;
}
