import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        ArrayList<String> namelist = new ArrayList<>();
        namelist.add("이서준");
        namelist.add("박승준");
        namelist.add("전규현");

        namelist.remove(3);

        System.out.println(namelist.size());
        System.out.println(namelist);
    }
}
