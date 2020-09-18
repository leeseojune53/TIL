import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Card> cards = new ArrayList<>();

        cards.add(new Card(2, 6));
        cards.add(new Card(4, 1));
        cards.add(new Card(3, 11));
        cards.add(new Card(3, 13));
        cards.add(new Card(1, 7));
        cards.add(new Card(3, 1));
        cards.add(new Card(4, 12));
        cards.add(new Card(1, 1));

        Collections.sort(cards);
        System.out.println(cards);
    }
}