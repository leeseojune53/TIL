package com.leeseojune.neisapi;

import com.leeseojune.neisapi.exceptions.detailed.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {
        NeisApi neisApi = new NeisApi.Builder().build();
        System.out.println("asdf");
        System.out.println(neisApi.getMealsByRelativeDay(0, "G10", "7430310"));

    }

}
