package org.loto.model;

public class Barrel {
    private static int number = 0;
    private int barrelNumber;

    public Barrel() {
        number++;
        if (number > 90) {
            throw new RuntimeException("Число у боченка не может быть больше 90");
        }
        barrelNumber = number;
    }

    public int getBarrelNumber() {
        return barrelNumber;
    }
}
