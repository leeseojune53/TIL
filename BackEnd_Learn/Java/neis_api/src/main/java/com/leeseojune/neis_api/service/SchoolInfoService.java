package com.leeseojune.neis_api.service;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public interface SchoolInfoService {

    void getMeal(String schoolCode, String ScCode, String date) throws IOException, SAXException, ParserConfigurationException;

}
