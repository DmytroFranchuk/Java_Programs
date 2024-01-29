package org.loto.view;

import org.loto.controller.Controller;
import org.loto.view.components.CardLabel;
import org.loto.view.components.CardPanel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class UserView extends JFrame {
    private Controller controller;
    private JButton getBarrel;
    private JButton mixAgain;



    private List<CardPanel> playerCards;
    private Integer[][] cardPlayer1;
    private Integer[][] cardPlayer2;
    private CardLabel outputPlayer1;
    private CardLabel outputPlayer2;
    private CardLabel outputGameResults;
    private int count = 1;
    private String str;
    boolean isGame = false;

    public UserView(Controller controller) {
        this.controller = controller;
    }

    public void init() {
        configWindow();
        playerCards = addCards();
        getBarrel = addButton("Достать из мешка", 25, 195, 150, 46);
        mixAgain = addButton("Сдать заново", 25, 260, 150, 46);
        addCardLabel();

        cardPlayer1 = controller.returnCard(1);
        cardPlayer2 = controller.returnCard(2);
        retake(cardPlayer1, cardPlayer2);

//        controller.addBagOfKegs();


        mixAgain.addActionListener(e -> {
            if (mixAgain.isEnabled()) {
                mixAgain.setEnabled(false);
                cardPlayer1 = controller.getExchangeCard(1);
                cardPlayer2 = controller.getExchangeCard(2);
                retake(cardPlayer1, cardPlayer2);
//                controller.addBagOfKegs();
                mixAgain.setEnabled(true);
                getBarrel.setEnabled(true);
            }
        });

        getBarrel.addActionListener(e -> {
            int currentBarrel = controller.getNumberBarrel();
            if (currentBarrel > 0)
                outputGameResults.setText(outputGameResults.getText() + " " + count++ + "[" + currentBarrel + "] ");
            else getBarrel.setEnabled(false);

            if (controller.checkOutputResult(1, currentBarrel))
                outputPlayer1.setText(outputPlayer1.getText() + " " + currentBarrel);
            if (controller.checkOutputResult(2, currentBarrel))
                outputPlayer2.setText(outputPlayer2.getText() + " " + currentBarrel);
            int winner = controller.checkResultGame();
            if (winner > 0) {
                if (winner == 1 || winner == 3) outputPlayer1.setText(outputPlayer1.getText() + " ПОБЕДА");
                if (winner == 2 || winner == 3) outputPlayer2.setText(outputPlayer2.getText() + " ПОБЕДА");
                getBarrel.setEnabled(false);
            }



//            try {
////                System.out.println(cardPlayer1[2][3].intValue());
//
//                Thread.sleep(200);
//            } catch (InterruptedException ex) {
//                throw new RuntimeException(ex);
//            }

//            controller.generateBarrelNumber();





//            if (count <= 90 && isGame) {
//                outputGameResults.setText(outputGameResults.getText() + " " + count++ + "[" + controller.generateBarrelNumber() + "] ");
//                str = outputGameResults.getText();
//            } else {
//                outputGameResults.setText(str + "< КОНЕЦ ИГРЫ !!! >");
//            }
        });

    }

    private void configWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(720, 540 + 1);
        setLocationRelativeTo(null);
        setTitle("Игра лото");
        setResizable(false);
        setVisible(true);
        setLayout(null);
    }

    private void addCardLabel() {
        outputPlayer1 = new CardLabel("ИГРОК 1 совпадения: ");
        outputPlayer1.createLabel(520, 15, 150, 160);
        add(outputPlayer1.getTextArea());

        outputPlayer2 = new CardLabel("ИГРОК 2 совпадения: ");
        outputPlayer2.createLabel(520, 327, 150, 160);
        add(outputPlayer2.getTextArea());

        outputGameResults = new CardLabel("НОМЕРА ИЗ МЕШКА: ");
        outputGameResults.createLabel(190, 191, 490, 120);
        add(outputGameResults.getTextArea());
    }

    private List<CardPanel> addCards() {
        List<CardPanel> result = new ArrayList<>(2);
        CardPanel cardPlayer1 = new CardPanel();
        cardPlayer1.setBounds(25, 15, 480, 160);
        result.add(cardPlayer1);
        add(cardPlayer1);

        CardPanel cardPlayer2 = new CardPanel();
        cardPlayer2.setBounds(25, 327, 480, 160);
        result.add(cardPlayer2);
        add(cardPlayer2);

        return result;
    }

    private JButton addButton(String text, int xPosition, int yPosition, int labelWidth, int labelHeight) {
        JButton button = new JButton(text);
        button.setBounds(xPosition, yPosition, labelWidth, labelHeight);
        add(button);
        return button;
    }

    private void retake(Integer[][] cardPlayer1, Integer[][] cardPlayer2) {
        try {
            for (int i = 0; i < cardPlayer1.length; i++) {
                for (int j = 0; j < cardPlayer1[i].length; j++) {
                    playerCards.get(0).setButtonText(i, j, "");
                    if (cardPlayer1[i][j] == -1) playerCards.get(0).setButtonEnabled(i, j, true);
                    else
                        playerCards.get(0).setButtonText(i, j, "" + cardPlayer1[i][j]);
                }
            }
            Thread.sleep(200);
            for (int i = 0; i < cardPlayer2.length; i++) {
                for (int j = 0; j < cardPlayer2[i].length; j++) {
                    playerCards.get(1).setButtonText(i, j, "");
                    if (cardPlayer2[i][j] == -1) playerCards.get(1).setButtonEnabled(i, j, true);
                    else
                        playerCards.get(1).setButtonText(i, j, "" + cardPlayer2[i][j]);
                }
            }
            count = 1;
            isGame = true;
            outputGameResults.setText("НОМЕРА ИЗ МЕШКА: ");
            outputPlayer1.setText("ИГРОК 1 совпадения: ");
            outputPlayer2.setText("ИГРОК 2 совпадения: ");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
