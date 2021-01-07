package com.dsm.daily_book.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class UserDTO {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class register{
        private String email;
        private String password;
        private String nickname;
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

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class mail{
        private String email;
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class authCode{
        private String email;
        private String code;
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class changeNickname{
        private String nickname;
    }
}
