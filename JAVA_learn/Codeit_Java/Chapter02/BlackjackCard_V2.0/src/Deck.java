import java.util.ArrayList;
import java.util.Random;

public class Deck<T extends Card> {
    private ArrayList<T> cards;

    public Deck() {
        cards = new ArrayList<T>();
    }

    public void addCard(T card) {
        cards.add(card);
    }

    public ArrayList<T> getCards() {
        return cards;
    }

    public void print() {
        for (T card : cards) {
            System.out.println(card.toString());
        }
    }

    public void shuffle() {
        Random random = new Random();

        for (int i = 0; i < cards.size(); i++) {
            int randIndex = random.nextInt(cards.size());
            T temp = cards.get(i);
            cards.set(i, cards.get(randIndex));
            cards.set(randIndex, temp);
        }
    }

    public Deck deal(int count) {
        Deck hand = new Deck();

        for (int i = 0; i < count; i++) {
            hand.addCard(cards.remove(0));
        }

        return hand;
    }
}