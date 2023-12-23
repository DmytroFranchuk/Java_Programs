package org.javaDzLambdaExpressions;

// Напишите функцию для подсчета квадрата числа и запустите его на числах от 1 до 10.
// Напишите с помощью лямбда выражений следующие формулы:
// вызовите функции на числах от 0 до 10

import java.util.Arrays;
import java.util.function.DoubleFunction;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        // Задание 1
        System.out.println(Arrays.toString(IntStream.range(0, 11)
                .map(Main::calculateSquare)
                .toArray()));

        // Задание 2-1
        System.out.println(Arrays.toString(IntStream.range(0, 11)
                .map(Main::formulaOne)
                .toArray()));
        // Задание 2-2
        System.out.println(Arrays.toString(IntStream.range(0, 11)
                .map(Main::formulaTwo)
                .toArray()));
        // Задание 2-3
        System.out.println(Arrays.toString(IntStream.range(0, 11)
                .map(Main::formulaThree)
                .toArray()));

        // Задание 3-1
        DoubleFunction<Double> formulaFour = x -> ((x * x) / 2) - ((2 * x) / 3) - ((x - 2) / 6);
        System.out.printf("Результат: %.3f%n", formulaFour.apply(5));
        // Задание 3-2
        DoubleFunction<Double> formulaFive = x -> (Math.pow(x - (1 / x), 0.5) + Math.pow(1 - (1 / x), 0.5));
        System.out.printf("Результат: %.2f%n", formulaFive.apply(5));
        // Задание 3-3
        DoubleFunction<Double> formulaSix = x -> (Math.sqrt(3 * x - 1) + Math.pow((1 + x), 2));
        System.out.printf("Результат: %.4f%n", formulaSix.apply(5));

        // Задание 4
        int a = 3;
        int b = 4;
        int c = 5;
        System.out.printf("Результат: %.1f%n", formulaHeron(a, b, c));
    }

    private static int calculateSquare(int x) {
        return x * x;
    }

    private static int formulaOne(int x) {
        return ((x * x) - (8 * x) + 12);
    }

    private static int formulaTwo(int x) {
        return ((5 * x * x) + (3 * x) + 7);
    }

    private static int formulaThree(int x) {
        return ((x * x) - (6 * x) + 9);
    }

    private static double formulaHeron(int a, int b, int c) {
        double p = (double) (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}