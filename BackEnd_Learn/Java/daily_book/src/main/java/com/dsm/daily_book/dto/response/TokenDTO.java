package com.dsm.daily_book.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class TokenDTO {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class token{
        private String accessToken;
        private String refreshToken;
    }
}
