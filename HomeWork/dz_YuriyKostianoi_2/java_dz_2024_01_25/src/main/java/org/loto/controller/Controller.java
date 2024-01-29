package org.loto.controller;

import org.loto.model.ModelGame;

public class Controller {
    private ModelGame model;

    public Controller(ModelGame model) {
        this.model = model;
    }

    public Integer[][] returnCard(int idPlayer) {
        return model.getPlayer(idPlayer).getPlayerCard().getCard();
    }

    public Integer[][] getExchangeCard(int idPlayer) {
        return model.exchangeCard(idPlayer).getCard();
    }

    public int getNumberBarrel() {
        if (model.getBasket().getBarrelList().size() > 0)
            return model.getBasket().takeBarrel().getBarrelNumber();
        else return -1;
    }

    public boolean checkOutputResult(int id, int currentBarrel) {
        return model.checkMatches(id, currentBarrel);
    }

    public int checkResultGame() {
        return model.checkWinner();
    }
}
