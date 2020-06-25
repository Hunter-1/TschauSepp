import Model.Game;
import Model.Spieler;
import Model.Stapel;
import Model.Tisch;
import javafx.scene.control.RadioButton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TschauSeppApp {
        public static void main(String[] args) {
            JFrame frame = new JFrame();
            JPanel panel = new JPanel();
            JLabel L = new JLabel(
                    "Bitte schreiben sie eine gewünschte Anzahl von Spieler");
            panel.add(L);
            JTextField text = new JTextField();
            text.setColumns(5);
            panel.add(text);
            JButton button = new JButton("Enter");
            button.addActionListener(actionEvent -> {
                if (isInteger(text.getText()) && (Integer.parseInt(text.getText())<=8 || Integer.parseInt(text.getText())>=2)){
                    frame.setVisible(false);
                    frame.dispose();
                    Stapel stack = new Stapel();
                    Tisch table = new Tisch();
                    Game game = new Game(Integer.parseInt(text.getText()), stack, table);
                    Frame f = new Frame(game);
                } else {
                    JOptionPane.showMessageDialog(frame,"Bitte schreiben sie eine Zahl zwischen 2 und 8");
                }
            });
            panel.add(button);
            frame.add(panel);
            frame.pack();
            frame.setVisible(true);

    }
    public static boolean isInteger( String input ) {
        try {
            Integer.parseInt( input );
            return true;
        }
        catch( Exception e ) {
            return false;
        }
    }
}

