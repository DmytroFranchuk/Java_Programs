package org.ls_2023_11_28_lambda.starter;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Starter3 {
    public static void main(String[] args) {

        File scr = new File(".");
        File[] files = scr.listFiles((p) -> p.isDirectory());

        for (File file : files) {
            System.out.println(file.getName());
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(String.format("%02d", i));
        }

        Collections.sort(list, (o1, o2) -> -o1.compareTo(o2));
        for (String s : list) {
            System.out.println(s);
        }

    }
}
