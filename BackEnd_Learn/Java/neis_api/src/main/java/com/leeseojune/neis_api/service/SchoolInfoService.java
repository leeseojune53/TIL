package com.leeseojune.neis_api.service;

import com.leeseojune.neis_api.dto.MealDTO;
import com.leeseojune.neis_api.dto.SchoolDTO;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public interface SchoolInfoService {

    MealDTO.MealRes getMeal(String schoolCode, String scCode, String date) throws IOException, SAXException, ParserConfigurationException;
    List<SchoolDTO.SchoolRes> getSchool(String name) throws ParserConfigurationException, IOException, SAXException;

}
