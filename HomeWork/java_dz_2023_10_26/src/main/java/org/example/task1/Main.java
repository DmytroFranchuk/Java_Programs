package org.example.task1;

// Напишите параметризированный метод для обмена позициями двух разных элементов в массиве.
// Метод принимает параметризированный массив и индексы элементов, которые нужно обменять.

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        System.out.println("Массив элементов: " + Arrays.toString(intArray));
        ArrayUtils.swapElements(intArray, 1, 3);
        System.out.println("Массив элементов: " + Arrays.toString(intArray));

    }
}