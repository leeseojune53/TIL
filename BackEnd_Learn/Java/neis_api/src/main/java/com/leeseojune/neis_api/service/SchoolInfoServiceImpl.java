package com.leeseojune.neis_api.service;

import com.leeseojune.neis_api.dto.MealDTO;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SchoolInfoServiceImpl implements SchoolInfoService{

    private static final String BASEURL = "https://open.neis.go.kr/hub/mealServiceDietInfo";

    @Override
    public MealDTO.MealRes getMeal(String schoolCode, String scCode, String date) throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
        Document doc = dBuilder.parse(BASEURL + "?ATPT_OFCDC_SC_CODE=" + scCode + "&SD_SCHUL_CODE=" + schoolCode + "&MLSV_YMD=" + date);

        doc.getDocumentElement().normalize();

        NodeList nList = doc.getElementsByTagName("row");

        MealDTO.MealRes response = new MealDTO.MealRes();

        for(int i=0, length = nList.getLength(); i < length; i++){
            Node node = nList.item(i);
            if(node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;

                List<String> menu = new ArrayList<>();
                String[] menus = getTagValue("DDISH_NM", element).split("[^\\uAC00-\\uD7AF\\u1100-\\u11FF\\u3130-\\u318F\n]");

                for(String value : menus){
                    if(value.length() != 0) {
                        menu.add(value);
                    }
                }

                switch (getTagValue("MMEAL_SC_NM", element)){
                    case "조식":
                        response.setBreakfast(menu);
                        break;
                    case "중식":
                        response.setLunch(menu);
                        break;
                    case "석식":
                        response.setDinner(menu);
                        break;
                    default:
                        break;
                }
            }
        }

        return response;
    }

    private String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();

        Node nValue = nodeList.item(0);
        if(nValue == null)
            return "";
        return nValue.getNodeValue();
    }

}
