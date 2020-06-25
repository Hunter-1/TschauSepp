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
    JLabel tableLabel = new JLabel();
    public Frame(Game g) {
        this.game = g;
        this.setResizable(false);
        mainPanel.add(tableLabel);
        addPanels();
        this.pack();
        this.setVisible(true);
    }
    public JPanel createPlayerPanels(){
        int i = 1;
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        for (Spieler player: game.getPlayers()
             ) {
            panel.add(new PlayerPanel(player,i));
            i++;
        }
        return panel;
    }
    public void addPanels(){
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(new TablePanel(game.getTable()), BorderLayout.NORTH);
        mainPanel.add(createPlayerPanels(), BorderLayout.CENTER);
        this.add(mainPanel);
    }
}
