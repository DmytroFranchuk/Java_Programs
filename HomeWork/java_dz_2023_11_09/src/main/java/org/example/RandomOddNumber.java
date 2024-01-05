package org.example;

import java.util.Random;

public class RandomOddNumber {
    public static void main(String[] args) {
        int randomNumber = generateRandomOddNumber(new Random());
        System.out.println("Случайное нечетное число: " + randomNumber);
    }

    public static int generateRandomOddNumber(Random random) {
        int randomNumber = 1;
        do {
            randomNumber = random.nextInt(201) - 100;
        } while (randomNumber % 2 == 0);
        return randomNumber;
    }
}