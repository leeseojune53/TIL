package com.example.userregistertest.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RegisterRequest {
    private String name;
    private Long password;
}
