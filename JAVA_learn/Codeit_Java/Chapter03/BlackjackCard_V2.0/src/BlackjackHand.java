import java.util.ArrayList;

public class BlackjackHand extends Deck{


    public int getValue(){
        int Value = 0;
        int aceCount = 0;
        for (Object i : getCards()){
            if(((BlackjackCard) i).isAce())
                aceCount++;
            Value+=((BlackjackCard) i).getValue();
        }
        while(Value>21 && aceCount > 0){
            Value-=10;
            aceCount--;
        }
        return Value;
    }

    public boolean isBusted(){
        return getValue()>21;
    }

    public boolean isBlackjack(){
        if(getCards().size() == 2 && getValue()==21){
            return true;
        }
        return false;
    }

}
