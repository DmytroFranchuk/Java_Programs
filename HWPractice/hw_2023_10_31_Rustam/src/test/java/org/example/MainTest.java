package org.example;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MainTest {

    //1) Напишите метод на Java для поиска общих элементов между двумя массивами целых чисел example input:
    //
    //Array1: [1, 2, 5, 5, 8, 9, 7, 10]
    //Array2: [1, 0, 6, 15, 6, 4, 7, 0]
    //example expected:
    //[1,7]
    @Test
    void testGetCommonElements() {
        int[] array1 = new int[]{1, 2, 5, 5, 8, 9, 7, 1};
        int[] array2 = new int[]{1, 0, 6, 15, 6, 4, 7, 0};
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(7);
        Assertions.assertEquals(expected, Main.getCommonElements(array1, array2));
    }

    @Test
    void testGetCommonElements_NullArray() {
        int[] array1 = new int[]{1, 2, 5, 5, 8, 9, 7, 1};
        int[] array2 = new int[0];
        Assertions.assertThrows(RuntimeException.class, () -> Main.getCommonElements(array1, array2));
    }

    //Напишите программу на Java для удаления повторяющихся элементов из массива.
    //
    //[0,3,-2,4,3,2]
    //example expected:
    //[0,3,-2,4,2]
    @Test
    void testRemoveDouble() {
        int[] arr = new int[]{0,3,-2,4,3,2};
        List<Integer> expected = new ArrayList<>(Arrays.asList(0,3,-2,4,2));
        Assertions.assertEquals(expected, Main.removeDouble(arr));
    }

    @Test
    void testRemoveDouble_NullArray() {
        int[] array = new int[0];
        Assertions.assertThrows(RuntimeException.class, () -> Main.removeDouble(array));
    }

    //Напишите программу на Java для поиска второго по величине элемента в массиве.
    //
    //example input:
    //[-1, 4, 0, 2, 7, -3]
    //
    //example expected:
    //4
    @Test
    void testGetTwoMax() {
        int[] arr = new int[]{-1, 4, 0, 2, 7, -3};
        int expected = 4;
        Assertions.assertEquals(expected, Main.getTwoMax(arr));
    }

    @Test
    void testGetTwoMax_NullArray() {
        int[] array = new int[0];
        Assertions.assertThrows(RuntimeException.class, () -> Main.getTwoMax(array));
    }

    //Напишите программу Java для поиска второго наименьшего элемента в массиве.
    //
    //example input:
    //[-1, 4, 0, 2, 7, -3]
    //example expected
    //-1
    @Test
    void getTwoMin() {
        int[] arr = new int[]{-1, 4, 0, 2, 7, -3};
        int expected = -1;
        Assertions.assertEquals(expected, Main.getTwoMin(arr));
    }

    @Test
    void testGetTwoMin_NullArray() {
        int[] array = new int[0];
        Assertions.assertThrows(RuntimeException.class, () -> Main.getTwoMin(array));
    }
}