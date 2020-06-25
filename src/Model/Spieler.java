package Model;

import java.util.ArrayList;

public class Spieler {
    private ArrayList<Karte> cards;
    private final Stapel stack;
    private final Tisch table;
    public Spieler(Stapel stack, Tisch table) {
        this.stack = stack;
        this.table = table;
        cards = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            this.getNewCard();
        }
        TableFirstCard();
    }
    public void getNewCard(){
        Karte card = stack.createCard();
        card.setPlayer(this);
        cards.add(card);
    }
    public boolean playCard(Karte card){
        if (table.getCard().getValue().equals(card.getValue())
                || table.getCard().getSuit().equals(card.getSuit())) {
        table.setCard(card);
        cards.remove(card);
        table.setOutput("can play card");
        if (cards.isEmpty()){
            gewinnen();
        }
        return true;
        } else {
            table.setOutput("can't play card");
        return false;}
    }
    public ArrayList<Karte> getCards() { return cards; }
    public void setCards(ArrayList<Karte> cards) { this.cards = cards; }
    public void TableFirstCard() {
        table.setCard(stack.createCard());
    }

    public Stapel getStack() {
        return stack;
    }
    public Tisch getTable() {
        return table;
    }

    public void toText() {
        System.out.println();
        for (Karte card:cards
             ) {
            System.out.print(card.toText()+ ",");
        }
    }
    public void gewinnen() {
        System.exit(777);
    }
}
