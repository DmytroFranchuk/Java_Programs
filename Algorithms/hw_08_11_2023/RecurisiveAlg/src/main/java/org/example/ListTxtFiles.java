package org.example;

import java.io.File;

public class ListTxtFiles {
    public static void main(String[] args) {
        System.out.println("========================= Результат выполнения программы =========================");
        String directoryPath = "C:\\Java\\2\\Java_Programs\\Algorithms";
        listTxtFiles(directoryPath);
    }

    static void listTxtFiles(String directoryPath) {
        File directory = new File(directoryPath);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Неверный путь к папке");
            return;
        }
        listFilesRecursively(directory);
    }

    static void listFilesRecursively(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().toLowerCase().endsWith(".txt")) {
                    System.out.println(file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    listFilesRecursively(file);
                }
            }
        }
    }
}
