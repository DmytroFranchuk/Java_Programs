package org.ls_2023_11_28_lambda.starter;

import java.io.File;
import java.io.FileFilter;

public class Starter {
    public static void main(String[] args) {

        File scr = new File(".");
        File[] files = scr.listFiles(new MyFilter());

        for (File file : files) {
            System.out.println(file.getName());
        }
    }
}

class MyFilter implements FileFilter {
    @Override
    public boolean accept(File pathname) {
        return pathname.isDirectory();
    }
}
