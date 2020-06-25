package View;

import Model.Game;
import Model.Spieler;
import Model.Tisch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TablePanel extends JPanel{
    JLabel tableLabel = new JLabel();
    JTextField output = new JTextField();
    JButton drawCard = new JButton();
    Game game;
    public TablePanel(Game game) {
        this.game=game;
        updateTable();
        output.setColumns(30);
        output.setEditable(false);
        drawCard.setText("Karte Ziehen");
        drawCard.addActionListener(actionEvent -> {
            Spieler player = game.getPlayers()[game.getTurns()];
            if (player.canGetNewCard()) {
                player.getNewCard();
                game.incrementPlayerTurns();
            }
        });
        this.setLayout(new FlowLayout());
        this.add(tableLabel);
        this.add(output);
        this.add(drawCard);
    }
    public void updateTable(){
        int delay = 10;
        ActionListener taskPerformer = actionEvent -> {
            tableLabel.setText("Tisch: " + game.getTable().getCard().toText()
                    + "\n" + " Am Zug: Spieler " + game.getPlayers()[game.getTurns()].getNum());
            output.setText(game.getTable().getOutput());
        };
        new Timer(delay,taskPerformer).start();
    }
}
