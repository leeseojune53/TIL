package com.leeseojune.todolist.error.excetion;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    BAD_REQUEST(400, "BadRequset."),
    NOT_FOUND(404, "NotFound.");

    private final int status;
    private final String message;

}
