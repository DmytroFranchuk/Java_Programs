package org.patternMVC.task1_CrossAndNaughts.model;

import org.patternMVC.task1_CrossAndNaughts.common.dto.CellState;
import org.patternMVC.task1_CrossAndNaughts.common.dto.GameResult;
import org.patternMVC.task1_CrossAndNaughts.common.dto.GameState;
import org.patternMVC.task1_CrossAndNaughts.common.interfaces.GameModel;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class CrossAndNaughts implements GameModel {
    private final CellState[][] field;
    private GameResult gameResult;
    private boolean isX;

    public CrossAndNaughts() {
        this.isX = ThreadLocalRandom.current().nextBoolean();
        this.field = initFild();
        this.gameResult = GameResult.UNDEFINED;
    }

    private CellState[][] initFild() {
        CellState[][] field = new CellState[3][3];
        for (CellState[] cellStates : field) {
            Arrays.fill(cellStates, CellState.EMPTY);
        }
        return field;
    }


    @Override
    public GameState mark(int raw, int column) {
        if (raw < 0 || raw >= field.length || column < 0 || column >= field[0].length) return toGameState();
        if (field[raw][column] != CellState.EMPTY) return toGameState();
        field[raw][column] = isX ? CellState.X : CellState.O;
        isX = !isX;
        // TODO сделать проверку окончания игры
        return toGameState();
    }

    private GameState toGameState() {
        CellState[][] copy = new CellState[field.length][field[0].length];
        for (int i = 0; i < field.length; i++) {
            copy[i] = Arrays.copyOf(field[i], field[i].length);
        }
        return new GameState(copy, gameResult);
    }
}
