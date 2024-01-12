package org.example.task2;

import java.util.HashMap;
import java.util.Map;

// Проверьте, равны ли два массива или нет
// Учитывая два массива, arr1 и arr2 одинаковой длины N, задача состоит в том, чтобы определить,
// равны ли данные массивы или нет.
// Два массива называются равными, если: оба они содержат один и тот же набор элементов,
// расположение (или перестановки) элементов может/не может быть одинаковым.
public class Main2 {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 5, 4, 0, 0};
        int[] arr2 = {0, 2, 4, 5, 0, 1};

        boolean result = areArraysEqual(arr1, arr2);
        System.out.println("Массивы равны: " + result);

    }

    public static boolean areArraysEqual(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        Map<Integer, Integer> mapArray1 = new HashMap<>();
        Map<Integer, Integer> mapArray2 = new HashMap<>();
        for (int num : arr1) {
            mapArray1.put(num, mapArray1.getOrDefault(num, 0) + 1);
        }
        for (int num : arr2) {
            mapArray2.put(num, mapArray2.getOrDefault(num, 0) + 1);
        }
        return mapArray1.equals(mapArray2);
    }
}
