package com.leeseojune.meal.dto;

import java.util.List;

public class Meal {

    private List<String> breakfast;

    private List<String> lunch;

    private List<String> dinner;

    public Meal setBreakfast(List<String> breakfast) {
        this.breakfast = breakfast;
        return this;
    }

    public Meal setLunch(List<String> lunch) {
        this.lunch = lunch;
        return this;
    }

    public Meal setDinner(List<String> dinner) {
        this.dinner = dinner;
        return this;
    }

    public Meal() {}

}
