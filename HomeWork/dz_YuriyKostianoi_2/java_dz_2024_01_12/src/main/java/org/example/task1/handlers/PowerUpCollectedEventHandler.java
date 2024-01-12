package org.example.task1.handlers;

import org.example.task1.annotation.EventHandler;

@EventHandler
public class PowerUpCollectedEventHandler {
    public void handlePowerUpCollectedEvent() {
        System.out.println("Усиление собрано");
    }

    @Override
    public String toString() {
        return "PowerUpCollectedEventHandler{}";
    }
}
