import Model.Spieler;
import Model.Stapel;
import Model.Tisch;

public class TschauSeppApp {
    public static void main(String[] args) {
        int playerAmount = 4;
        Stapel stack = new Stapel();
        Tisch table = new Tisch();
        Spieler[] players = new Spieler[playerAmount] ;
        for (int i = 0; i < playerAmount; i++) {
            players[i] = new Spieler(stack,table);
        }
        Frame f = new Frame(players, table);
    }
}
