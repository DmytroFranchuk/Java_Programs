package org.pr_2023_12_22_Synchronizers.task1_Phaser;

import java.util.concurrent.Phaser;

// В стартапе есть несколько этапов разработки, и команды работают параллельно над различными
// аспектами проекта. Используйте Phaser, чтобы синхронизировать выполнение команд на различных этапах.

public class Main_Phaser {
    private static final int TEAMS = 5;
    private static final int STEPS = 5;
    private static final Phaser PHASER = new Phaser(TEAMS);

    public static void main(String[] args) {
        for (int step = 1; step <= STEPS; step++) {
            System.out.println("Фаза - " + step + " началась ... ");
            for (int team = 1; team <= TEAMS; team++) {
                int finalTeam = team;
                int finalStep = step;
                Thread teamThread = new Thread(() -> {
                    System.out.println("Команда - " + finalTeam + " работает над фазой - " + PHASER.getPhase());
                    PHASER.arriveAndAwaitAdvance();
//                    System.out.println("Поток - " + Thread.currentThread().getId() + " завешен");
                });
                teamThread.start();
            }
            PHASER.arriveAndAwaitAdvance();
        }
        System.out.println("Проект закончен !!!");
    }
}
