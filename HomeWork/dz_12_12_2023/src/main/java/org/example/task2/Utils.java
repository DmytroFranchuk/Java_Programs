package org.example.task2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class Utils {

    private Utils() { }

    public static List<Integer> removeNegativeValuesParallel(List<Integer> list) {
        List<Integer> result = new CopyOnWriteArrayList<>(list);
        return result.parallelStream()
                .filter(el -> el > 0)
                .distinct()
                .sorted(Comparator.comparingInt(Integer::intValue))
                .collect(Collectors.toList());
    }

    public static List<Integer> removeNegativeValues(List<Integer> list) {
        List<Integer> result = new ArrayList<>(list);
        return result.stream()
                .filter(el -> el > 0)
                .distinct()
                .sorted(Comparator.comparingInt(Integer::intValue))
                .toList();
    }
}
