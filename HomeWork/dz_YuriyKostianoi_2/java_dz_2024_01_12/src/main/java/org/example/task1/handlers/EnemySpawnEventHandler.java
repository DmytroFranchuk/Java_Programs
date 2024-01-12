package org.example.task1.handlers;

import org.example.task1.annotation.EventHandler;

@EventHandler
public class EnemySpawnEventHandler {

    public void handleEnemySpawnEvent() {
        System.out.println("Враг появился");
    }

    @Override
    public String toString() {
        return "EnemySpawnEventHandler{}";
    }
}
