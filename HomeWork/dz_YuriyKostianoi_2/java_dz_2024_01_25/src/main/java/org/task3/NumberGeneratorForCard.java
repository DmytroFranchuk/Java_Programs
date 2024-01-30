package org.task3;

import java.util.concurrent.ThreadLocalRandom;

public class NumberGeneratorForCard {
    public static void main(String[] args) {
        init();

    }

    private static void init() {
//        int count = 1;
        int[][] dataSet = new int[3][9];
        for (int i = 0; i < dataSet.length; i++) {
            for (int j = 0; j < dataSet[i].length; j++) {


                dataSet[i][j] = ThreadLocalRandom.current().nextInt(1, 91);

                System.out.print("[" + i + ":" + j + "]-" + dataSet[i][j] + " ");
            }
            System.out.println();
        }
    }
}
