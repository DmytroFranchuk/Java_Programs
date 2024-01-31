package org.task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class NumberGeneratorForCard {

    public static void main(String[] args) {
//        printCard(init());
    }

    public static int[][] init() {
        int[][] dataSet = new int[3][9];
        for (int i = 0; i < dataSet.length; i++) {
            for (int j = 0; j < dataSet[i].length; j++) {
                dataSet[i][j] = generateValue(i, j, dataSet);
            }
        }
        return initCard(dataSet);
    }

    private static int generateValue(int row, int base, int[][] array) {
        int value;
        do {
            value = base * 10 + ((base == 8) ? generateFromRange(0, 11) : generateFromRange(0, 10));
            if ((row == 1 && value == array[0][base]) || (row == 2 && (value == array[0][base] || value == array[1][base]))) {
                value = 0;
            }
        } while (value == 0);
        return value;
    }

    private static int generateFromRange(int from, int before) {
        return ThreadLocalRandom.current().nextInt(from, before);
    }

    private static int[][] initCard(int[][] array) {
        int shift = 5; // max = 5, min = 0;
        List<Integer> tempColumn = changeSequence(9);
//        System.out.println(Arrays.toString(tempColumn.toArray()));
        for (int i = shift; i < shift + 4; i++) {
            array[0][tempColumn.get(i) - 1] = -1;
        }

        shift = 1;
        do {
            tempColumn = changeSequence(9);
//            System.out.println(Arrays.toString(tempColumn.toArray()));
            for (int i = shift; i < shift + 4; i++) {
                array[1][tempColumn.get(i) - 1] = -1;
            }
        } while (hasMatchingColumns(array));
        int[] temp = new int[9];

        int x1 = 0;
        int y1 = 0;
        for (int i = 0; i < array[0].length; i++) {
            if (array[0][i] != -1 && array[1][i] != -1) {
                array[2][i] = -1;
                temp[i] = array[2][i];
            }
            if (array[0][i] == array[1][i]) temp[i] = array[2][i];
            if (temp[i] == 0) {
                x1++;
            }
            if (temp[i] == -1) {
                y1++;
            }
        }
        tempColumn.clear();
        System.out.println(Arrays.toString(temp));
        System.out.println("x1: " + x1 + " y1: " + y1);

        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == 0) tempColumn.add(i);
        }
        Collections.shuffle(tempColumn);
        int w = 0;
        int f = 0;
        while (y1 < 4) {
            if (temp[w] == 0) {
                array[2][tempColumn.get(f)] = -1;
                f++;
                y1++;
            }
            w++;
        }



        System.out.println(Arrays.deepToString(array));
        return array;
    }

    private static List<Integer> changeSequence(int numbers) {
        List<Integer> sequence = new ArrayList<>();
        for (int i = 0; i < numbers; i++) {
            sequence.add(i + 1);
        }
        Collections.shuffle(sequence);
        return sequence;
    }

    private static boolean hasMatchingColumns(int[][] array) {
        int value = 0;
        for (int i = 0; i < array[0].length; i++) {
            if (array[0][i] == array[1][i]) value++;
        }
        return (value >= 5);
    }

    private static void printCard(int[][] array) {
        for (int[] row : array) {
            for (int value : row) {
                System.out.print("[" + value + "] ");
            }
            System.out.println();
        }
    }
}