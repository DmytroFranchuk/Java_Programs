package org.example.game;

public class GameSaveResult {
   String name;
   int winCounter;
   int loseCounter;

    public GameSaveResult(String name) {
        this.name = name;
        this.winCounter = 0;
        this.loseCounter = 0;
    }

    public void setWinCounter(int winCounter) {
        this.winCounter = winCounter;
    }

    public void setLoseCounter(int loseCounter) {
        this.loseCounter = loseCounter;
    }

    public int getWinCounter() {
        return winCounter;
    }

    public int getLoseCounter() {
        return loseCounter;
    }

    public String getName() {
        return name;
    }
}
