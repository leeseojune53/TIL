package com.leeseojune.neis_api.service;

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

@Service
public class SchoolInfoServiceImpl implements SchoolInfoService{

    private final String baseUrl = "https://open.neis.go.kr/hub/mealServiceDietInfo";

    @Override
    public void getMeal(String schoolCode, String scCode, String date) throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
        Document doc = dBuilder.parse(baseUrl + "?ATPT_OFCDC_SC_CODE=" + scCode + "&SD_SCHUL_CODE=" + schoolCode + "&MLSV_YMD=" + date);

        doc.getDocumentElement().normalize();

        NodeList nList = doc.getElementsByTagName("row");

        for(int i=0, length = nList.getLength(); i < length; i++){
            Node node = nList.item(i);
            if(node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println(getTagValue("MMEAL_SC_NM", element));
                System.out.println(getTagValue("DDISH_NM", element));
            }
        }




        System.out.println(nList.getLength());
    }

    private String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();

        Node nValue = (Node) nodeList.item(0);
        if(nValue == null)
            return null;
        return nValue.getNodeValue();
    }

}
