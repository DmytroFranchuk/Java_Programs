package org.example;

// 1. Найти первый элемент, встречающийся k раз в массиве
// 2. Проверьте, равны ли два массива или нет (массивы считаются равными, если содержат одинаковые элементы,
// порядок не важен)
// 3. Сгруппируйте слова с одинаковым набором символов
// Дан список слов со строчными буквами. Реализуйте функцию поиска всех слов с одинаковым уникальным набором символов.
// Вход: String words[] = {"student", "students", "dog", "god", "cat", "act", "flow", "wolf"};
// Выход: student, students, cat, act, dog, god, flow, wolf

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Task 1
        System.out.println("====================================================================================");
        int[] array = ThreadLocalRandom.current().ints(20, 1, 11).toArray();
        int k = 3;
        System.out.println("Массив элементов: " + Arrays.toString(array));
        System.out.printf("Первый элемент, который встречается в массиве %d раза: %d%n", k, firstElementWithKOccurrences(array, k));
        System.out.println("====================================================================================");

        // Task 2
        int[] array1 = {1, 2, 3, 4, 5, 5, 4, 3, 2, 1};
        int[] array2 = {5, 3, 2, 4, 1, 1, 2, 3, 4, 5};
        System.out.println("Равны ли два массива: " + arraysEqualWithoutOrder(array1, array2));
        System.out.println("====================================================================================");

        // Task 3
        String[] words = {"student", "students", "dog", "god", "cat", "act", "flow", "wolf",
                "maska", "kasma", "1234", "1122"};
        Map<String, List<String>> groupedWords = Arrays.stream(words)
                .collect(Collectors.groupingBy(Main::getUniqueCharacters, Collectors.toList()));
        groupedWords.forEach((key, value) -> {
            if (value.size() > 1) {
                System.out.println(String.join(", ", value));
            }
        });
        System.out.println("====================================================================================");
    }

    public static int firstElementWithKOccurrences(int[] array, int k) {
        Map<Integer, Long> result = Arrays.stream(array)
                .boxed()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        return result.entrySet().stream()
                .filter(e -> e.getValue() == k)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(-1);
    }

    public static boolean arraysEqualWithoutOrder(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) return false;
        Map<Integer, Long> counter1 = Arrays.stream(arr1)
                .boxed()
                .collect(HashMap::new, (map, num) -> map.merge(num, 1L, Long::sum), HashMap::putAll);
        Map<Integer, Long> counter2 = Arrays.stream(arr2)
                .boxed()
                .collect(HashMap::new, (map, num) -> map.merge(num, 1L, Long::sum), HashMap::putAll);
        return counter1.equals(counter2);
    }

    private static String getUniqueCharacters(String word) {
        return word.chars()
                .distinct()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}