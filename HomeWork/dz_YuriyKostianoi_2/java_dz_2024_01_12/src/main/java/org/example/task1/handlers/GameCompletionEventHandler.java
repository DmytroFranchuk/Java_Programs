package org.example.task1.handlers;

import org.example.task1.annotation.EventHandler;

@EventHandler
public class GameCompletionEventHandler {
    public void handleGameCompletionEvent() {
        System.out.println("Игра завершена");
    }

    @Override
    public String toString() {
        return "GameCompletionEventHandler{}";
    }
}
