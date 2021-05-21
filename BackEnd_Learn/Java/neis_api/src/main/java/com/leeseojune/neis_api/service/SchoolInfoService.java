package com.leeseojune.neis_api.service;

import com.leeseojune.neis_api.dto.MealDTO;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public interface SchoolInfoService {

    List<MealDTO.MealRes> getMeal(String schoolCode, String ScCode, String date) throws IOException, SAXException, ParserConfigurationException;

}
