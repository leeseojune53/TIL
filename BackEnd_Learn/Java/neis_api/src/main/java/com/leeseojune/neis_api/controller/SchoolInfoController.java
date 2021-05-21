package com.leeseojune.neis_api.controller;

import com.leeseojune.neis_api.dto.MealDTO;
import com.leeseojune.neis_api.service.SchoolInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class SchoolInfoController {

    private final SchoolInfoService schoolInfoService;

    @GetMapping("/meal")
    public List<MealDTO.MealRes> getMeal(@RequestBody MealDTO.MealReq request) throws IOException, ParserConfigurationException, SAXException {
        return schoolInfoService.getMeal(request.getSchoolCode(), request.getScCode(), request.getDate());
    }

}
