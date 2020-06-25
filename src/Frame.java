import Model.Game;
import Model.Spieler;
import Model.Tisch;
import View.PlayerPanel;
import View.TablePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Frame extends JFrame {
    Game game;
    JPanel mainPanel = new JPanel();
    JPanel bigplayerPanel;
    JLabel tableLabel = new JLabel();
    public Frame(Game g) {
        this.game = g;
        this.setResizable(false);
        
        addPanels();
        this.pack();
        this.setSize(this.getWidth(),this.getHeight()+100);
        this.setVisible(true);
    }
    public JPanel createPlayerPanels(TablePanel table){
        int i = 1;
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        for (Spieler player: game.getPlayers()
             ) {
            panel.add(new PlayerPanel(player,i,table));
            i++;
        }
        return panel;
    }
    public void addPanels(){
        TablePanel table = new TablePanel(game);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(table, BorderLayout.NORTH);
        bigplayerPanel = createPlayerPanels(table);
        mainPanel.add(bigplayerPanel, BorderLayout.CENTER);
        this.add(mainPanel);
    }
}
