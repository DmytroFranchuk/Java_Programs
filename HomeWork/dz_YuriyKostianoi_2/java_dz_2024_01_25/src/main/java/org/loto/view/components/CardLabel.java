package org.loto.view.components;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;

public class CardLabel {
    private final static Font FONT = new Font("Arial", Font.PLAIN, 12);

    private JTextArea textArea;
    private String text;

    public CardLabel(String text) {
        this.text = text;
        this.textArea = new JTextArea(text);
    }

    public void createLabel(int xPosition, int yPosition, int labelWidth, int labelHeight) {
        this.textArea.setBackground(new ColorUIResource(238, 238, 238));
        this.textArea.setBounds(xPosition, yPosition, labelWidth, labelHeight);
        this.textArea.setWrapStyleWord(true);
        this.textArea.setHighlighter(null);
        this.textArea.setFocusable(false);
        this.textArea.setEditable(false);
        this.textArea.setEditable(false);
        this.textArea.setLineWrap(true);
        this.textArea.setFont(FONT);
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        this.textArea.setText(text);
        this.textArea.repaint();
    }
}
