package com.leeseojune.neis_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

public class MealDTO {

    @AllArgsConstructor
    @Getter
    public static class MealReq {
        String schoolCode;
        String scCode;
        String date;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class MealRes {
        private List<String> breakfast;
        private List<String> lunch;
        private List<String> dinner;
    }

}
