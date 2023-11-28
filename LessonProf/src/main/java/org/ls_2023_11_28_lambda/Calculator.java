package org.ls_2023_11_28_lambda;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Calculator {
//  2 Напишите метод, который принимает мапу «Номер квартиры – Список возрастов жильцов».
//  Метод возвращает мапу «Номер квартиры – Средний возраст жильцов».
    public static void main(String[] args) {
        System.out.println(getFlatToAverageAge(Map.of(
                1, List.of(23,43,54,3,54,22),
                2, List.of(10,20,30),
                3, List.of(32,45,12,5),
                4, List.of(23,43)
        )));

    }

    private static Map<Integer, Double> getFlatToAverageAge(Map<Integer, List<Integer>> flatToAges) {
        Map<Integer, Double> result = new HashMap<>();
        flatToAges.forEach((k, v) -> result.put(k, avgList(v)));
        return result;
    }
    private static double avgList(List<Integer> list) {
        AtomicInteger sum = new AtomicInteger();
        list.forEach(sum::addAndGet);
        return 1.0 * sum.get() / list.size();
    }
}
