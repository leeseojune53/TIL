public class Main {
    public static void main(String[] args) {
        BlackjackCard card1 = new BlackjackCard(1, 1);
        BlackjackCard card2 = new BlackjackCard(2, 6);
        BlackjackCard card3 = new BlackjackCard(4, 12);

        System.out.println(card1.getValue());
        System.out.println(card1.isAce());
        System.out.println(card2.getValue());
        System.out.println(card2.isAce());
        System.out.println(card3.getValue());
        System.out.println(card3.isAce());
    }
}