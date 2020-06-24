package View;

import Model.Tisch;

import javax.swing.*;

public class TablePanel extends JPanel{
    public TablePanel(Tisch table) {
        JLabel tableLabel = new JLabel();
        tableLabel.setText("Tisch: " + table.getCard().toText());
        JTextField output = new JTextField();
        output.setColumns(30);
        output.setEditable(false);
        this.add(tableLabel);
        this.add(output);
    }
}
