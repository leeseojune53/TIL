package com.leeseojune.neis_api.controller;

import com.leeseojune.neis_api.dto.MealDTO;
import com.leeseojune.neis_api.dto.SchoolDTO;
import com.leeseojune.neis_api.service.SchoolInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public MealDTO getMeal(@RequestParam("schoolCode") String schoolCode, @RequestParam("scCode") String scCode, @RequestParam("date") String date) throws IOException, ParserConfigurationException, SAXException {
        return schoolInfoService.getMeal(schoolCode, scCode, date);
    }

    @GetMapping("/school")
    public List<SchoolDTO> getSchool(@RequestParam("name") String name) throws IOException, SAXException, ParserConfigurationException {
        return schoolInfoService.getSchool(name);
    }

}
