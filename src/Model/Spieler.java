package Model;

import java.util.ArrayList;

public class Spieler {
    private ArrayList<Karte> cards;
    private final Stapel stack;
    private final Tisch table;
    private final Game game;
    private int num;
    private boolean active = false;
    public Spieler(Stapel stack, Tisch table, Game game,int num) {
        this.stack = stack;
        this.table = table;
        this.game = game;
        this.num = num;
        cards = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            this.getNewCard();
        }
        TableFirstCard();
    }
    public void getNewCard(){
        Karte card = stack.createCard();
        card.setPlayer(this);
        cards.add(card);
    }
    public Karte returnNewCard(){
        Karte card = stack.createCard();
        card.setPlayer(this);
        return card;
    }
    public boolean canGetNewCard(){
        return true;
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
                table.setOutput("");
                return true;
            } else {
                table.setOutput("Ungültige Karte, Tisch karte ist " + table.getCard().toText());
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
        System.out.println(num);

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

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
