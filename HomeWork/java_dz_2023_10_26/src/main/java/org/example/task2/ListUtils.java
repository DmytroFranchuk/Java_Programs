package org.example.task2;

import java.util.List;

public class ListUtils {
    public static <T extends Comparable<? super T>> T findMaxInRange(List<T> list, int begin, int end) {
        if (begin < 0 || end > list.size() || begin >= end) {
            throw new IllegalArgumentException("Invalid range");
        }
        T max = list.get(begin);
        for (int i = begin + 1; i <= end; i++) {
            T current = list.get(i);
            if (current.compareTo(max) > 0) {
                max = current;
            }
        }
        return max;
    }
}
