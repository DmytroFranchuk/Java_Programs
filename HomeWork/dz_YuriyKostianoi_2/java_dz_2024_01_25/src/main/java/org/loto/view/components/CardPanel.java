package org.loto.view.components;

import javax.swing.*;
import java.awt.*;

public class CardPanel extends JPanel {
    private static final int ROWS = 3;
    private static final int COLUMNS = 9;
    private final JButton[][] buttons;
    private final static Font FONT = new Font("Times New Roman", Font.ITALIC | Font.BOLD, 18);

    public CardPanel() {
        setLayout(new GridLayout(ROWS, COLUMNS));
        buttons = new JButton[ROWS][COLUMNS];
        int number = 1;
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                buttons[row][col] = createField();
//                buttons[row][col].setText(String.valueOf(number++));
                buttons[row][col].setFont(FONT);
                add(buttons[row][col]);
            }
        }
    }

    private JButton createField() {
        JButton button = new JButton();
        button.setPreferredSize(new Dimension(50, 50));
        return button;
    }

    public void setButtonEnabled(int row, int col, boolean enabled) {
        buttons[row][col].setEnabled(enabled);
    }

    public void setButtonText(int row, int col, String text) {
        buttons[row][col].setText(text);
    }
}
