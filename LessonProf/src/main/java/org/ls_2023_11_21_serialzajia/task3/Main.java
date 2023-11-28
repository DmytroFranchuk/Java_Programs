package org.ls_2023_11_21_serialzajia.task3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        InputStream input = args.length == 0? System.in : new FileInputStream(args[0]);
        List<Integer> result = getFromUser(input);
        System.out.println(result);
    }

    private static List<Integer> getFromUser(InputStream input) {
        Scanner sc = new Scanner(input);
        List<Integer> nums = new ArrayList<>();
        while (true) {
            String line = sc.nextLine();
            if (line.equalsIgnoreCase("quit")) break;
            try {
                int num = Integer.parseInt(line);
                nums.add(num);
            } catch (NumberFormatException e) {
                System.out.println("Невозможно расспознать число " + line);
            }
        }
        return nums;
    }
}
