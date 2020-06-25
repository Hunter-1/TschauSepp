package View;
import Model.Spieler;

import javax.swing.*;
import java.awt.*;


public class PlayerPanel extends JPanel {
    Spieler player;
    int playerNum;
    TablePanel table;
    CardPanel cardPanel;
    public PlayerPanel(Spieler player, int num, TablePanel table) {
        this.player = player;
        this.table = table;
        playerNum = num;
        player.setNum(playerNum);
        init();
    }
    public void init(){
        this.add(new JLabel("Player " + playerNum));
        this.cardPanel = new CardPanel(player, table);
        JScrollPane scroll = new JScrollPane(
                cardPanel,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS
        );
        scroll.setPreferredSize(new Dimension(600,55));
        this.add(scroll);
    }

}
