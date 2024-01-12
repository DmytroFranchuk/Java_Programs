package org.example.task1.handlers;

import org.example.task1.annotation.EventHandler;

@EventHandler
public class ScoreUpdateEventHandler {
    public void handleScoreUpdateEvent() {
        System.out.println("Оценка обновлена");
    }

    @Override
    public String toString() {
        return "ScoreUpdateEventHandler{}";
    }
}
