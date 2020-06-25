package View;

import Model.Karte;
import Model.Spieler;
import javafx.scene.control.Tab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CardPanel extends JPanel {
    Spieler player;
    TablePanel table;
    public CardPanel(Spieler player, TablePanel table) {
        this.player = player;
        this.table = table;
        init();
    }
    public void init(){
        for (Karte card: player.getCards()) {
            JButton button = createCardButton(card);
            this.add(button);
        }
    }
    public JButton createCardButton(Karte card){
        JButton button = new JButton(card.toText());
        button.addActionListener(actionEvent -> {
            if (player.canPlayCard(card)){
                player.playCard(card);
            remove(button);}
            table.updateTable();
            this.revalidate();
            this.repaint();
        });
        return button;
    }
}
