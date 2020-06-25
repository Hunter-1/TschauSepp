package Model;

import java.util.ArrayList;

public class Spieler {
    private ArrayList<Karte> cards;
    private final Stapel stack;
    private final Tisch table;
    private final Game game;
    private boolean active = false;
    public Spieler(Stapel stack, Tisch table, Game game) {
        this.stack = stack;
        this.table = table;
        this.game = game;
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
    public void playCard(Karte card){
                table.setCard(card);
                cards.remove(card);
                if (cards.isEmpty()) {
                    gewinnen();
                }
                game.incrementPlayerTurns();
    }
    public boolean canPlayCard(Karte card){
        if (active) {
            if (table.getCard().getValue().equals(card.getValue())
                    || table.getCard().getSuit().equals(card.getSuit())) {
                return true;
            } else {
                table.setOutput("Ungültige Karte, Tischakarte ist " + table.getCard().toText());
                return false;
            }
        }
        table.setOutput("Diese Spieler ist nicht am Zug!");
        return false;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
