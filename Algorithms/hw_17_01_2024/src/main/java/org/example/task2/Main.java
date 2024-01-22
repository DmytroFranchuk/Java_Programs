package org.example.task2;

// Имеется отсортированный массив строк, в котором могут присутствовать
// пустые строки. Напишите метод для определения позиции заданной строки.

public class Main {
    public static void main(String[] args) {
        String[] sortedArray = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", "", "", ""};
        String targetString = "ball";
        int position = findStringPosition(sortedArray, targetString);
        if (position != -1) {
            System.out.println("Строка '" + targetString + "' найдена на позиции " + position + ".");
        } else {
            System.out.println("Строка '" + targetString + "' не найдена в массиве.");
        }
    }

    private static int findStringPosition(String[] sortedArray, String target) {
        int left = 0;
        int right = sortedArray.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            while (mid <= right && sortedArray[mid].isEmpty()) {
                mid++;
            }
            if (mid > right) {
                right = left + (right - left) / 2;
                continue;
            }
            int compareResult = target.compareTo(sortedArray[mid]);
            if (compareResult == 0) {
                return mid;
            } else if (compareResult < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
