package org.example;

// Реализуйте метод rand7() на базе метода rand5().
// Другими словами, имеется метод, генерирующий случайные числа в диапазоне
// от О до 4 (включительно).
// Напишите метод, который использует его для генерирования случайного числа в
// диапазоне от О до 6 (включительно).

import java.util.Random;

public class RandomGenerator {
    public static void main(String[] args) {
        for (int i = 1; i < 6; i++) {
            System.out.print(rand7() + ", ");
        }
    }

    public static int random5(){ // 0 1 2 3 4
        Random random = new Random();
        return random.nextInt(5);
    }

    public static int rand7() {
        return (random5() + random5()) % 7;
    }
}
