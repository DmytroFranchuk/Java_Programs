package org.patternMVC.task1_CrossAndNaughts.common.interfaces;

import org.patternMVC.task1_CrossAndNaughts.common.dto.GameState;

public interface GameModel {
    GameState mark(int raw, int column);
}
