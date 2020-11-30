package com.example.connectredis;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TestRequest {
    private String key;
    private String value;
    private long duration;
}
