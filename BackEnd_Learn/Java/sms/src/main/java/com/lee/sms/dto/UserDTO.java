package com.lee.sms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserDTO {

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class UserInfo{
        private String name;
        private String password;
        private String phone;
    }
}
