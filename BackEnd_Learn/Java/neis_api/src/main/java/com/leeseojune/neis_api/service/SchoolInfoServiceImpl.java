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

    private final String baseUrl = "https://open.neis.go.kr/hub/mealServiceDietInfo";

    @Override
    public List<MealDTO.MealRes> getMeal(String schoolCode, String scCode, String date) throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
        Document doc = dBuilder.parse(baseUrl + "?ATPT_OFCDC_SC_CODE=" + scCode + "&SD_SCHUL_CODE=" + schoolCode + "&MLSV_YMD=" + date);

        doc.getDocumentElement().normalize();

        NodeList nList = doc.getElementsByTagName("row");

        List<MealDTO.MealRes> response = new ArrayList<>();

        for(int i=0, length = nList.getLength(); i < length; i++){
            Node node = nList.item(i);
            if(node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                List<String> menu = new ArrayList<>();
                System.out.println();
                String[] menus = getTagValue("DDISH_NM", element).split("[^\\uAC00-\\uD7AF\\u1100-\\u11FF\\u3130-\\u318F\n]");
                for(String value : menus){
                    if(value.length() != 0) {
                        menu.add(value);
                    }
                }
                response.add(new MealDTO.MealRes(getTagValue("MMEAL_SC_NM", element), menu));
            }
        }
        return response;

    }

    private String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();

        Node nValue = (Node) nodeList.item(0);
        if(nValue == null)
            return "";
        return nValue.getNodeValue();
    }

}
