package org.example;

import java.util.Random;

public class RandomGenerator {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.print(rand7() + " ][ ");
        }
    }

    public static int rand5() {
        Random random = new Random();
        return random.nextInt(5);
    }

    public static int rand7() {
        int num;
        do {
            // Генерируем число в диапазоне от 0 до 24
            num = 5 * rand5() + rand5();
        } while (num >= 21); // Повторяем, если число больше или равно 21

        // Возвращаем число в диапазоне от 0 до 6
        return num % 7;
    }
}
