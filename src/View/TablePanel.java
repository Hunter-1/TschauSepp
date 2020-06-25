package View;

import Model.Tisch;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        ActionListener taskPerformer = actionEvent -> {
            tableLabel.setText("Tisch: " + table.getCard().toText());
            output.setText(table.getOutput());
        };
        new Timer(delay,taskPerformer).start();

    }
}
