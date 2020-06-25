package View;

import Model.Karte;
import Model.Spieler;

import javax.swing.*;

public class CardPanel extends JPanel {
    Spieler player;
    public CardPanel(Spieler player) {
        this.player = player;
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
            revalidate();
            repaint();
        });
        return button;
    }
}
