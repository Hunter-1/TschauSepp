package Model;

public class Karte {
    private final String value;
    private final String suit;
    private Spieler player;

    public Karte(String value,String suit) {
        this.value = value;
        this.suit = suit;
    }
    public String getValue() { return value; }
    public String getSuit() { return suit; }
    public Spieler getPlayer() { return player; }
    public void setPlayer(Spieler player) { this.player = player; }
    public String toText(){
        return suit + " " + value;
    }
}
