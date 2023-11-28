package org.ls_2023_11_07_unitTest;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        StringUtils stringUtils;
        ArrayUtils arrayUtils;
        NumberUtils numberUtils;

        String[] fruits = {"apple", "pear", "lemon"};
//        System.out.println(ArrayUtils.contains(fruits, "lemon")); // => true
//        System.out.println(ArrayUtils.contains(fruits, "orange")); // => false

        // Напишите программу на Java для поиска общих элементов между двумя массивами
        // целых чисел
        // example input:
        // Array1: [1, 2, 5, 5, 8, 9, 7, 10]
        // Array2: [1, 0, 6, 15, 6, 4, 7, 0]
        // example expected: [1, 7]
        int[] arr1 = {1, 2, 5, 5, 8, 9, 7, 10};
        int[] arr2 = {1, 0, 6, 15, 6, 4, 7, 0};
        System.out.println(findCommonElements(arr1, arr2));
        int[] arr3 = {0, 3, -2, 4, 3, 2};

        System.out.println(removeDuplicateFromArray(arr3));
        int[] arr4 = {-1, 4, 0, 2, 7, -3};
        System.out.println(getTwoMaxElement(arr4));
    }

    public static List<Integer> findCommonElements(int[] arr1, int[] arr2) {
        if (arr1.length == 0 || arr2.length == 0) {
            throw new IllegalArgumentException("One of the arrays is empty");
        }
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    list.add(arr1[i]);
                }
            }
        }
        return list;
    }

    // Напишите программу на Java для удаления повторяющихся элементов из массива.
    // example input: [0,3,-2,4,3,2]
    // example expected: [0,3,-2,4,2]

    public static List<Integer> removeDuplicateFromArray(int[] arr) {
        if (arr.length == 0 || arr == null) {
            throw new IllegalArgumentException("Arrays is empty");
        }
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (set.add(arr[i])) {
                list.add(arr[i]);
            }
        }
        return list;
    }

    public static int getTwoMaxElement(int[] arr) {
        if (arr.length < 2) {
            throw new IllegalArgumentException("Array is too short");
        }
        int max_1 = Integer.MAX_VALUE;
        int max_2 = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < max_1) {
                max_2 = max_1;
                max_1 = arr[i];
            } else if (arr[i] < max_2 && arr[i] > max_1) {
                max_2 = arr[i];
            }
        }
        return max_2;
    }
}