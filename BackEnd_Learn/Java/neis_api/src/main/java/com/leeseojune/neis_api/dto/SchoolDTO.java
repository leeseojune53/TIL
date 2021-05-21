package com.leeseojune.neis_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class SchoolDTO {

    @AllArgsConstructor
    @Getter
    public static class SchoolRes {
        private String scCode;
        private String schoolCode;
        private String location;
        private String name;
    }

}
