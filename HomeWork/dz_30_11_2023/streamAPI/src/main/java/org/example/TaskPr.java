package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TaskPr {
    public static void main(String[] args) {

        // Создайте список чисел и используйте Stream API, чтобы получить первые три элемента,
        // а затем пропустить следующие два.
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
        List<Integer> result = numbers.stream()
                .collect(Collectors.groupingBy(e -> numbers.indexOf(e) / 5))
                .values()
                .stream()
                .flatMap(s -> s.stream().limit(s.size() - 2))
                .collect(Collectors.toList());
        System.out.println(result);

        List<Integer> result1 = IntStream.range(0, numbers.size())
                .flatMap(i -> (i % 5 < 3) ? IntStream.of(numbers.get(i)) : IntStream.empty())
                .boxed()
                .collect(Collectors.toList());
        System.out.println(result1);

        // Пропустить два элемента после первых трех элементов
        List<Integer> result2 = IntStream.range(0, numbers.size())
                .filter(i -> i < 3 || i >= 5)
                .mapToObj(numbers::get)
                .collect(Collectors.toList());
        System.out.println(result2);

        //
        List<Integer> result3 = numbers.stream()
                .limit(5)
                .skip(2)
                .collect(Collectors.toList());
        System.out.println(result3);
    }
}
