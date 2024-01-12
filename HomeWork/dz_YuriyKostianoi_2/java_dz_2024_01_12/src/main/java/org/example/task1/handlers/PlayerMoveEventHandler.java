package org.example.task1.handlers;

import org.example.task1.annotation.EventHandler;

@EventHandler
public class PlayerMoveEventHandler {
    public void handlePlayerMoveEvent() {
        System.out.println("Игрок идёт");
    }

    @Override
    public String toString() {
        return "PlayerMoveEventHandler{}";
    }
}
