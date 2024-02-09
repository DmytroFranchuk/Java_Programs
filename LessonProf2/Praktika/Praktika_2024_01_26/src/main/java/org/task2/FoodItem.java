package org.task2;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class FoodItem {
    private final String name;
    private final LocalDate expirationDate;

    public FoodItem(String name) {
        this.name = name;
        this.expirationDate = getRandomDate();
    }

    private LocalDate getRandomDate() {
        return LocalDate.now().plusDays(ThreadLocalRandom.current().nextInt(-10, 10));
    }

    public String getName() {
        return name;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }
}

