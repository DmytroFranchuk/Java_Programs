package org.patternMVC.task1_CrossAndNaughts.common.dto;

import jakarta.persistence.Entity;


public record GameState(CellState[][] cells, GameResult result) {
}
