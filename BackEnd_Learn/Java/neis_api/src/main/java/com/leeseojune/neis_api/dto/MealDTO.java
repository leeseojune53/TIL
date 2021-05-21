package com.leeseojune.neis_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

public class MealDTO {

    @AllArgsConstructor
    @Getter
    public static class MealReq {
        String schoolCode;
        String ScCode;
        String date;
    }

    @AllArgsConstructor
    @Getter
    public static class MealRes {
        private String mealName;
        private List<String> menu;
    }

}
