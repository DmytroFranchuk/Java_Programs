package org.loto.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private static int number = 0;
    private int id;
//    private String name;
    private Card card;
//    private String outputText;
    private List<Integer> listClosedField;

    public Player() {
        this.id = ++number;
//        this.name = "Player " + this.id;
        this.card = new Card();
//        this.outputText = "ИГРОК " + this.id + " совпадения: ";
        this.listClosedField = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    public Card getPlayerCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

//    public String getOutputText() {
//        return outputText;
//    }
//
//    public void setOutputText(String outputText) {
//        this.outputText = outputText;
//    }

    public List<Integer> getListClosedField() {
        return listClosedField;
    }

    public void setListClosedField(int numBarrel) {
        this.listClosedField.add(numBarrel);
    }

    public void clearListClosedField() {
        this.listClosedField.clear();
    }
}
