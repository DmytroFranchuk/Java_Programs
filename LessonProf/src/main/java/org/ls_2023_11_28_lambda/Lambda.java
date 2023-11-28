package org.ls_2023_11_28_lambda;

import java.util.List;

public class Lambda {
//    3 Создайте 3 лямбда-выражения, которые выводят строку в консоль разными способами.
//    Передайте все лямбда-выражения в метод в виде коллекции и выведите все строки в консоль.
    public static void main(String[] args) {
        Runnable print1 = () -> System.out.println("Dima Franchuk");
        Runnable print2 = () -> System.out.printf("Dima Franchuk %d %n", 25);
        Runnable print3 = () -> System.err.printf("Страшная ошибка");
        printAll(List.of(print1, print2, print3));
    }
    private static void printAll(List<Runnable> list) {
        list.forEach(Runnable::run);
    }
}
