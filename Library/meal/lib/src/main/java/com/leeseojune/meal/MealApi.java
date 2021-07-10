package com.leeseojune.meal;

import com.leeseojune.meal.dto.Meal;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Instance of the MealApi class provider access to the neis api
 */
public class MealApi {

    private static final String MEAL_DEFAULT_HOST = "https://open.neis.go.kr/hub/mealServiceDietInfo";

    private static final String SCHOOL_DEFAULT_HOST = "https://open.neis.go.kr/hub/schoolInfo";

    private static final Pattern PATTERN_BRACKET = Pattern.compile("\\([^\\(\\)]+\\)");

    private static final String MENU_PATTERN = "[^\\uAC00-\\uD7AF\\u1100-\\u11FF\\u3130-\\u318F\n]";

    /**
     *
     * @param day                                                       ex)20210616
     * @param scCode Neis calls this parameter "ATPT_OFCDC_SC_CODE"     ex)G10
     * @param schoolCode Neis calls this parameter "SD_SCHUL_CODE"      ex)7430310
     * @return Meals breakfast, lunch, dinner
     * @throws
     */
    public Meal getMealsByAbsoluteDay(String day, String scCode, String schoolCode) {
        Document doc;

        try{
            DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
            doc = dBuilder.parse(MEAL_DEFAULT_HOST + "?ATPT_OFCDC_SC_CODE=" + scCode + "&SD_SCHUL_CODE=" + schoolCode
                    + "&MLSV_YMD=" + day);
        }catch(ParserConfigurationException | SAXException | IOException e){
            throw new ParseErrorException();
        }
        return getMeal(doc);
    }

    /**
     *
     * @param day                                                       ex)10
     * @param scCode Neis calls this parameter "ATPT_OFCDC_SC_CODE"     ex)G10
     * @param schoolCode Neis calls this parameter "SD_SCHUL_CODE"      ex)7430310
     * @return
     */
    public Meal getMealsByRelativeDay(int day, String scCode, String schoolCode) {
        LocalDate date = LocalDate.now().plusDays(day);
        Document doc;

        try{
            DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
            doc = dBuilder.parse(MEAL_DEFAULT_HOST + "?ATPT_OFCDC_SC_CODE=" + scCode + "&SD_SCHUL_CODE=" + schoolCode
                    + "&MLSV_YMD=" + date.toString().replace("-", ""));
        }catch(ParserConfigurationException | SAXException | IOException e){
            throw new ParseErrorException();
        }

        return getMeal(doc);
    }

    private Meal getMeal(Document doc) {
        doc.getDocumentElement().normalize();

        NodeList nList = doc.getElementsByTagName("row");

        Meal response = new Meal();

        for (int i = 0, length = nList.getLength(); i < length; i++) {
            Node node = nList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;

                List<String> menu = new ArrayList<>();
                String[] menus = deleteBracketTextByPattern(getTagValue("DDISH_NM", element)).split(MENU_PATTERN);

                for (String value : menus) {
                    if (value.length() != 0) {
                        menu.add(value);
                    }
                }

                switch (getTagValue("MMEAL_SC_NM", element)) {
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
        if (nValue == null)
            return "";
        return nValue.getNodeValue();
    }

    private static String deleteBracketTextByPattern(String text) {

        Matcher matcher = PATTERN_BRACKET.matcher(text);

        String pureText = text;
        String removeTextArea;

        while (matcher.find()) {
            int startIndex = matcher.start();
            int endIndex = matcher.end();

            removeTextArea = pureText.substring(startIndex, endIndex);
            pureText = pureText.replace(removeTextArea, "");
            matcher = PATTERN_BRACKET.matcher(pureText);
        }

        return pureText;
    }

}
