package View;

import Model.Tisch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TablePanel extends JPanel{
    JLabel tableLabel = new JLabel();
    JTextField output = new JTextField();
    Tisch table;

    public TablePanel(Tisch table) {
        this.table=table;
        updateTable();
        output.setColumns(30);
        output.setEditable(false);
        this.add(tableLabel);
        this.add(output);
    }
    public void updateTable(){
        int delay = 10;
        ActionListener taskPerformer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                output.setText();
                tableLabel.setText("Tisch: " + table.getCard().toText());
            }
        };
        new Timer(delay,taskPerformer).start();

    }
}
