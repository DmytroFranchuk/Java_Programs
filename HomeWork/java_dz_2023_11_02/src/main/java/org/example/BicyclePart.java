package org.example;
/**
 * Класс, представляющий деталь велосипеда.
 */
public class BicyclePart {
    private int strength;
    private boolean isBroken;
    private String name;
    private int count;

    public BicyclePart(String name, int strength) {
        this.name = name;
        this.strength = strength;
        if (strength > 0) isBroken = true;
        count = 0;
    }

    public boolean isBroken() {
        return isBroken;
    }

    public int getStrength() {
        return strength;
    }

    public int getCount() {
        return count;
    }

    public void use(int damage) {
        count++;
        strength -= damage;
        if (strength <= 0) {
            System.out.println(name + " сломано!");
            isBroken = false;
        }
    }
}
