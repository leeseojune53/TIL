package com.leeseojune.neis_api.service;

import com.leeseojune.neis_api.dto.MealDTO;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public interface SchoolInfoService {

    MealDTO.MealRes getMeal(String schoolCode, String scCode, String date) throws IOException, SAXException, ParserConfigurationException;

}
