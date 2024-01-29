package org.bugFix;

import java.util.Random;

/**
 * Основной класс программы.
 */
public class Main {
    public static void main(String[] args) {
        Bicycle bicycle = new Bicycle();
    }
}

/**
 * Класс, представляющий велосипед и его части.
 */
class Bicycle {
    private static final int MAX_STRENGTH = 100;

    /**
     * Внутренний класс, представляющий часть велосипеда.
     */
    class Part {
        private String name;
        private int strength;

        /**
         * Конструктор для создания части велосипеда.
         *
         * @param name название части
         */
        Part(String name) {
            this.name = name;
            this.strength = MAX_STRENGTH;
        }

        /**
         * Уменьшает прочность части на указанное количество.
         *
         * @param damageAmount количество прочности, которое следует уменьшить
         */
        void damage(int damageAmount) {
            strength = Math.max(0, strength - damageAmount);
            if (strength == 0) {
                System.out.println(name + " is broken!");
            } else {
                System.out.println(name + " is damaged. Remaining strength: " + strength);
            }
        }

        /**
         * Проверяет, сломана ли часть велосипеда.
         *
         * @return true, если часть сломана, иначе false
         */
        boolean isBroken() {
            return strength == 0;
        }
    }

    // Внутренние классы для различных частей велосипеда
    class Handlebar extends Part {
        Handlebar() {
            super("Handlebar");
        }
    }

    class Seat extends Part {
        Seat() {
            super("Seat");
        }
    }

    class Wheel extends Part {
        Wheel() {
            super("Wheel");
        }
    }

    class Gear extends Part {
        Gear() {
            super("Gear");
        }
    }

    class Frame extends Part {
        Frame() {
            super("Frame");
        }
    }

    /**
     * Конструктор для создания объекта велосипеда и эмуляции поездки.
     */
    Bicycle() {
        Handlebar handlebar = new Handlebar();
        Seat seat = new Seat();
        Wheel frontWheel = new Wheel();
        Wheel rearWheel = new Wheel();
        Gear gear = new Gear();
        Frame frame = new Frame();

        Random random = new Random();

        boolean notBroken = true;

        while (notBroken) {
            // Показывает, что велосипед двигается

            // Эмуляция встречи с препятствиями и получения повреждений
            int obstacleStrength = random.nextInt(20) + 1; // Прочность препятствия

            // Выбор случайной части для повреждения
            int partIndex = random.nextInt(6);

            switch (partIndex) {
                case 0:
                    handlebar.damage(obstacleStrength);
                    break;
                case 1:
                    seat.damage(obstacleStrength);
                    break;
                case 2:
                    frontWheel.damage(obstacleStrength);
                    break;
                case 3:
                    rearWheel.damage(obstacleStrength);
                    break;
                case 4:
                    gear.damage(obstacleStrength);
                    break;
                case 5:
                    frame.damage(obstacleStrength);
                    break;
            }

            // Проверка, не сломана ли хотя бы одна часть
            notBroken = !(handlebar.isBroken() || seat.isBroken() ||
                    frontWheel.isBroken() || rearWheel.isBroken() ||
                    gear.isBroken() || frame.isBroken());
        }

        System.out.println("The bicycle is no longer rideable.");
    }
}