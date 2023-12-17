package org.pr_2023_12_15;

import java.util.concurrent.atomic.AtomicInteger;

public class LeafPileSimulation {
    private final static int INITIAL_HEIGHT = 100; // Начальная высота кучи в см
    private final static int MIN_HEIGHT_TO_JUMP = 30; // Минимальная высота для прыжков в см

    private final AtomicInteger pileHeight = new AtomicInteger(INITIAL_HEIGHT);

    public void collectLeaves() {
        // Дети собирают листья в кучу
        while (pileHeight.get() > MIN_HEIGHT_TO_JUMP) {
            System.out.println("Дети собирают листья в кучу");
            // Атомарно уменьшаем высоту кучи на 10 см
            pileHeight.getAndAdd(-10);
        }
        System.out.println("Куча уменьшилась до " + MIN_HEIGHT_TO_JUMP + " см");
    }

    public void jumpIntoPile() {
        // Дети начинают прыгать в кучу листьев
        while (pileHeight.get() >= MIN_HEIGHT_TO_JUMP) {
            System.out.println("Дети прыгают в кучу листьев");
            // Атомарно уменьшаем высоту кучи на 10 см за каждый прыжок
            pileHeight.getAndAdd(-10);
        }
        System.out.println("Куча уменьшилась до " + pileHeight.get() + " см");
    }
}
