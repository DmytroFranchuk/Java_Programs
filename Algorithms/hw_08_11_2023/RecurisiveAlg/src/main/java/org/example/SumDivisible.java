package org.example;

public class SumDivisible {
    public static void main(String[] args) {
        int result1 = sum(7, 2);
        System.out.println("sum(7, 2) = " + result1);

        int result2 = sum(12, 3);
        System.out.println("sum(12, 3) = " + result2);

        int result3 = sumRecurisive(7, 2);
        System.out.println("sumRecurisive(7, 2) = " + result3);

        int result4 = sumRecurisive(12, 3);
        System.out.println("sumRecurisive(12, 3) = " + result4);
    }

    static int sum(int n, int m) {
        if (n <= 1) {
            return 0;
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i % m == 0) sum += i;
        }
        return sum;
    }

    static int sumRecurisive(int n, int m) {
        if (n <= 1) {
            return 0;
        }
        int current = n % m == 0 ? n : 0;
        return sumRecurisive(n - 1, m) + current;
    }
}