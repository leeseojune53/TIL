package com.leeseojune.awss3.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class FileDTO {

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class FileName{
        private String name;
    }
}
