package org.ls_2023_11_28_lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) {
        List<String> list = List.of("s2", "1s", "S4", "sS", "Ss", "1", "d", "D", "56", "8f2", "ran");
        System.out.println(filterByDigit(list));
    }

    private static boolean startsWithDigit(String str) {
        if (str == null || str.isEmpty()) return false;
        return Character.isDigit(str.charAt(0));
    }
    private static List<String> filterByDigit(List<String> strList) {
        List<String> result = new ArrayList<>();
        strList.forEach(s -> { if (startsWithDigit(s)) result.add(s); });
        return result;
    }
}
