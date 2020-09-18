import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<Card> cards = new ArrayList<>();

    public ArrayList<Card> getCards(){
        return cards;
    }

    public void addCard(Card card){
        cards.add(card);
    }

    public void print(){
        for(Card i:cards){
            System.out.println(i.toString());
        }
    }

    public void shuffle(){
        Random random = new Random();
        for (int i = 0; i < cards.size(); i++) {
            int randIndex = random.nextInt(cards.size());
            Card temp = cards.get(i);
            cards.set(i, cards.get(randIndex));
            cards.set(randIndex, temp);
        }
    }

    public Deck deal(int count){
        Deck hand = new Deck();
        if(count == 5){
            for(int i = 0; i<5;i++){
                hand.addCard(cards.get(cards.size()-i-1));
                cards.remove(cards.size()-i-1);
            }
        }
        return hand;
    }
}
