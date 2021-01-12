package com.dsm.daily_book.entity.diary;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public enum Mood {
    HAPPY(1), FINE(2), BAD(3), SAD(4), ANGRY(5);

    int i;
    Mood(int i){
        this.i = i;
    }
    public static Mood value(int value){
        switch(value){
            case 1:
                return HAPPY;
            case 2:
                return FINE;
            case 3:
                return BAD;
            case 4:
                return SAD;
            case 5:
                return ANGRY;
            default:
                return HAPPY;
        }
    }

    public static int reverseValue(Mood value){
        if(value.equals(HAPPY))
            return 1;
        else if(value.equals(FINE))
            return 2;
        else if(value.equals(BAD))
            return 3;
        else if(value.equals(SAD))
            return 4;
        else if(value.equals(ANGRY))
            return 5;
        else return 1;
    }
}
