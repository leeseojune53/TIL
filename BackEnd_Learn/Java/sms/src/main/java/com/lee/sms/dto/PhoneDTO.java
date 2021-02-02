package com.lee.sms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


public class PhoneDTO {

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class PhoneNumber{
        private String phone;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class Verify{
        private String phone;
        private String numStr;
    }
}
