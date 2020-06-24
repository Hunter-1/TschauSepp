package Model;

import java.util.Random;

public class Stapel {
    private final String[] Suits = {"Ecke","Herz","Schaufel","Kreuz"};
    private final String[] Values = {"1","2","3","4","5","6","7","8","9"};

    public Karte createCard (){
        String value = Values[new Random().nextInt(Values.length)];
        String suit = Suits[new Random().nextInt(Suits.length)];
        return new Karte(value,suit);
    }
}
