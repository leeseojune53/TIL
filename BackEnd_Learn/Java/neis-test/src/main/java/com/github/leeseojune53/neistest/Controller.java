package com.github.leeseojune53.neistest;

import com.leeseojune.neisapi.NeisApi;
import com.leeseojune.neisapi.dto.School;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final NeisApi neisApi = new NeisApi.Builder().build();

    @GetMapping("/meal")
    public void meal() {
        try{
            for(School school : neisApi.getSchoolByName("대덕소")) {
                System.out.println(school.getScCode() + " " + school.getSchoolCode() + " " + school.getName());
                System.out.println(neisApi.getMealsByRelativeDay(0, school.getScCode(), school.getSchoolCode()).getBreakfast());
                System.out.println();
            }
        }catch (Exception e) {
            System.out.println("Error");
        }

    }

}
