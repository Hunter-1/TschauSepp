package View;
import Model.Spieler;

import javax.swing.*;


public class PlayerPanel extends JPanel {
    Spieler player;
    int playerNum;
    public PlayerPanel(Spieler player, int num) {
        this.player = player;
        playerNum = num;
        init();
    }
    public void init(){
        this.add(new JLabel("Player " + playerNum));
        this.add(new CardPanel(player));
    }

}
