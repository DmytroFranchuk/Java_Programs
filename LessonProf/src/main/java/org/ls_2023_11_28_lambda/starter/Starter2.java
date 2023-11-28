package org.ls_2023_11_28_lambda.starter;

import java.io.File;
import java.io.FileFilter;

public class Starter2 {
    public static void main(String[] args) {

        File scr = new File(".");
        File[] files = scr.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });

        for (File file : files) {
            System.out.println(file.getName());
        }
    }
}
