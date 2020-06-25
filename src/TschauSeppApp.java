import Model.Game;
import Model.Spieler;
import Model.Stapel;
import Model.Tisch;

public class TschauSeppApp {
        public static void main(String[] args) {
            int playerAmount = 4;
            Stapel stack = new Stapel();
            Tisch table = new Tisch();
            Game game = new Game(playerAmount, stack, table);
            Frame f = new Frame(game);
    }
}

