package org.example;

import org.example.dzLambda.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Predicate;

public class App {
    public static void main(String[] args) {
        // 1 Task
        List<Integer> numbersList = List.of(-3, -2, -1, 0, -1, -2, 3);
        numbersList.forEach(x -> System.out.printf("%d ", Math.abs(x)));
        System.out.println();

        // 2 Task
        Item item1 = new Item("sausage", 2.45);
        Item item2 = new Item("bread", 1.46);
        Item item3 = new Item("milk", 0.95);
        Item item4 = new Item("cookie", 2.33);
        Item item5 = new Item("chocolate", 2.99);
        Map<Item, Integer> mapItems = Map.of(item1, 1, item2, 2,
                item3, 3, item4, 5, item5, 2);
        mapItems.forEach((k, v) -> {
            if (v < 3) {
                System.out.println("Товар: " + k.nameProduct() + " - " + v + " шт.");
            }
        });

        // 3 Task
        RandomIntegerNumber randomNumber = (x, y) -> {
            if (x >= y) {
                throw new IllegalArgumentException("Range error");
            }
            Random rd = new Random();
            return rd.nextInt(y - x + 1) + x;
        };
        int generatedNumber = randomNumber.generate(-10, 10);
        System.out.println("Случайное число: " + generatedNumber);

        // 4 Task
        List<String> stringList = new ArrayList<>(List.of("Ardo", "Ariston", "Samsung", "Bosh", "AEG", "Whirlpool"));
        char startingLetter = 'A';
        Predicate<String> predicate = (str) -> !str.isEmpty() && str.charAt(0) == startingLetter;
        stringList.removeIf(predicate);
        System.out.println("Список строк после удаления элементов, начинающихся с буквы " + startingLetter + ":");
        stringList.forEach(System.out::println);
    }
}

@FunctionalInterface
interface RandomIntegerNumber {
    int generate(int start, int end);
}
