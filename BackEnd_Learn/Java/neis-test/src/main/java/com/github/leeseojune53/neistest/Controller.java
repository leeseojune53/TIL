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
            for(School school : neisApi.getSchoolByName("대덕")) {
                System.out.println(school.getName());
            }
        }catch (Exception e) {
            System.out.println("Error");
        }

    }

}
