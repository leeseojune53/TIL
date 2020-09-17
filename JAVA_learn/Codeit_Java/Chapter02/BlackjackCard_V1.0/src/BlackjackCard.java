public class BlackjackCard extends  Card{

    BlackjackCard(int suitNumber, int rankNumber){
        super(suitNumber, rankNumber);
    }

    public int getValue(){
        if(2<=rankNumber && rankNumber<=10){
            return rankNumber;
        }
        switch (rankNumber){
            case 1:
                return 11;
            case 11:
            case 12:
            case 13:
                return 10;
        }
        return 0;
    }

    public boolean isAce(){
        if(rankNumber == 1)
            return true;
        return false;
    }



}
