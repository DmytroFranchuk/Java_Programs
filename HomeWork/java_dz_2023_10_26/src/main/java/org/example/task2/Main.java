package org.example.task2;

import java.util.List;

// Напишите параметризированный метод для нахождения максимального элемента в диапазоне [begin, end)
// среди элементов List. Какую границу должен иметь параметр такого метода?
public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(3, 7, 2, 8, 1, 5, 4, 9, 6);
        int begin = 2;
        int end = 7;
        Integer maxInRange = ListUtils.findMaxInRange(numbers, begin, end);
        System.out.println(("Максимальный элемент в диапазоне [" + begin + ", " + end + "): " + maxInRange));

    }

}
