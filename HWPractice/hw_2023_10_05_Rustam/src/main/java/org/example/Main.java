package org.example;

// Дана коллекция Arrays.asList("f10", "f15", "f2", "f4", "f4"). Нужно выполнить сортировку в обратном алфавитному
// порядке и удалить дубликаты. В массиве должны оказаться только уникальные значения
// Пусть дана коллекция состоящая из строк. Arrays.asList(«Highload», «High», «Load», «Highload»).
// Вывести, сколько раз объект «High» встречается в коллекции.
// Какой элемент в коллекции находится на первом месте? Если мы получили пустую коллекцию, то пусть возвращается 0.
// Нужно пройтись от -40 до 40, возвести каждое значение в квадрат, отфильтровать все что больше 100 и собрать в
// List
// Set
// LinkedList (посмотрите в документации что принимает Collectors.toCollection(..))

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        // Task 1
        List<String> values = Arrays.asList("f10", "f15", "f2", "f4", "f4");
        List<String> uniqueSortedValues = values.stream()
                .sorted(Comparator.reverseOrder())
                .distinct()
                .toList();
        System.out.println("Уникальные значения, отсортированные в обратном порядке:");
        uniqueSortedValues.forEach(System.out::println);

        // Task 2
        List<String> strings = Arrays.asList("Highload", "High", "Load", "Highload");
        String firstElement = strings.get(0);
        long countOfHigh = strings.stream()
                .filter("High"::equals)
                .count();
        System.out.println("Количество вхождений объекта \"High\": " + countOfHigh);
        System.out.println("Первый элемент в коллекции: " + firstElement);

        // Task 3
        List<Integer> listResult = IntStream.range(-40, 41)
                .map(i -> i * i)
                .filter(i -> i > 100)
                .boxed()
                .toList();
        Set<Integer> setResult = IntStream.range(-40, 41)
                .map(i -> i * i)
                .filter(i -> i > 100)
                .boxed()
                .collect(Collectors.toSet());
        LinkedList<Integer> linkedListResult = IntStream.range(-40, 41)
                .map(i -> i * i)
                .filter(i -> i > 100)
                .boxed()
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.println("List: " + listResult);
        System.out.println("Set: " + setResult);
        System.out.println("LinkedList: " + linkedListResult);
    }
}