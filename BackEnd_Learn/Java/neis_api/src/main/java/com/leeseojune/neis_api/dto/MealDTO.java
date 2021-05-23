package com.leeseojune.neis_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MealDTO {

    private List<String> breakfast;
    private List<String> lunch;
    private List<String> dinner;

}
