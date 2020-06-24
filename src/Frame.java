import Model.Spieler;
import Model.Tisch;
import View.PlayerPanel;
import View.TablePanel;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    Spieler[] players;
    Tisch table;
    JPanel mainPanel = new JPanel();
    JLabel tableLabel = new JLabel();
    public Frame(Spieler[] players, Tisch table) {
        this.players = players;
        this.table = table;
        this.setResizable(false);
        mainPanel.add(tableLabel);
        //debug();
        addPanels();
        this.pack();
        this.setVisible(true);
    }
    public JPanel createPlayerPanels(){
        int i = 1;
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        for (Spieler player: players
             ) {
            panel.add(new PlayerPanel(player,i));
            i++;
        }
        return panel;
    }
    public void debug(){
        players[0].toText();
        players[1].toText();
        players[2].toText();
        players[3].toText();
    }
    public void addPanels(){
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(new TablePanel(table), BorderLayout.NORTH);
        mainPanel.add(createPlayerPanels(), BorderLayout.CENTER);
        this.add(mainPanel);
    }
}
