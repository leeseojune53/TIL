import java.util.HashMap;

public class WordDictionary {
    private HashMap<String, String> dictionary = new HashMap<>();
    public void addWord(String key, String value){
        dictionary.put(key.toUpperCase(),value);
    }

    public String find(String name){
        return dictionary.get(name.toUpperCase());
    }
}
