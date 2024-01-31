package org.loto.model;

public class ModelGame {
    private Player player1;
    private Player player2;
    private Basket basket;

    public ModelGame() {
        this.player1 = new Player();
        this.player2 = new Player();
        this.basket = Basket.getInstance();
    }

    public Player getPlayer(int idPlayer) {
        return idPlayer == 1 ? player1 : player2;
    }

    public Card exchangeCard(int idPlayer) {
        Card card = new Card();
        basket.resetBasket();
        if (idPlayer == 1) {
            player1.setCard(card);
            player1.clearListClosedField();
        }
        else {
            player2.setCard(card);
            player2.clearListClosedField();
        }
        return card;
    }

    public int checkWinner() {
        int result = 0;
        if (player1.getListClosedField().size() == 15) result += player1.getId();
        if (player2.getListClosedField().size() == 15) result += player2.getId();
        return result;
    }

    public Basket getBasket() {
        return basket;
    }

    public boolean checkMatches(int idPlayer, int barrelValue) {
        Player player;
        if (idPlayer == 1) player = player1;
        else player = player2;
        int [][] checkCard = player.getPlayerCard().getCard();
        for (int i = 0; i < checkCard.length; i++) {
            for (int j = 0; j < checkCard[i].length; j++) {
                if (checkCard[i][j] == barrelValue) {
                    player.setListClosedField(barrelValue);
                    return true;
                }
            }
        }
        return false;
    }
}
