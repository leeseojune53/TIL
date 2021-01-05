package com.dsm.daily_book.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class User {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class register{
        private String email;
        private String password;
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class auth{
        private String email;
        private String password;

        public UsernamePasswordAuthenticationToken getAuthToken(int userCode){
            return new UsernamePasswordAuthenticationToken(userCode, password);
        }
    }
}
