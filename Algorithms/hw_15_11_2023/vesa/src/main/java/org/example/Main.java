package org.example;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Решить задачу одним из методов динамического программирования:
        // Самый дешёвый путь
        // В каждой клетке прямоугольной таблицы N*M записано некоторое число.
        // Изначально игрок находится в левой верхней клетке. За один ход ему разрешается перемещаться в соседнюю
        // клетку либо вправо, либо вниз
        // (влево и вверх перемещаться запрещено). При проходе через клетку игрок платит определенную сумму,
        // значение которой записано в этой клетке.
        // Требуется найти минимальную стоимость пути, отдав которую игрок может попасть в правый нижний угол.
        //
        // Входные данные:
        // int[][] costs = new int[][]{{0, 1, 4, 4},
        // {4, 1, 1, 1},
        // {4, 4, 4, 1},
        // {4, 4, 4, 0}};
        //
        // Результат: minCost(costs) = 5

        int[][] costs = new int[][]{
                {0, 1, 4, 4},
                {4, 1, 1, 1},
                {4, 4, 4, 1},
                {4, 4, 4, 0}
        };
        System.out.println(minTravelCost(costs));
    }

    public static int minTravelCost(int[][] costs) {
        int N = costs.length;
        int M = costs[0].length;
        int[][] dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = costs[i][j];
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + costs[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + costs[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + costs[i][j], dp[i][j - 1] + costs[i][j]);
                }
            }
        }
        System.out.println(Arrays.toString(dp[0]));
        System.out.println(Arrays.toString(dp[1]));
        System.out.println(Arrays.toString(dp[2]));
        System.out.println(Arrays.toString(dp[3]));
        return dp[N - 1][M - 1];
    }

    public static int min(int a, int b) {
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }
}
