public class Card {
    public final int suitNumber;
    public final int rankNumber;

    public Card(int suitNumber, int rankNumber){
        this.suitNumber = suitNumber;
        this.rankNumber = rankNumber;
    }
    public String getSuit(){
        switch (suitNumber){
            case 1:
                return "Clubs";
            case 2:
                return "Hearts";
            case 3:
                return "Diamonds";
            case 4:
                return "Spades";
        }
        return "";
    }
    public String getRank(){
        if(2<=rankNumber&&rankNumber<=10)
            return Integer.toString(rankNumber);
        else{
            switch (rankNumber){
                case 1:
                    return "Ace";
                case 11:
                    return "Jack";
                case 12:
                    return "Queen";
                case 13:
                    return "King";
            }
        }
        return "";
    }

    @Override
    public String toString(){
        return getRank() + " of " + getSuit();
    }
}
