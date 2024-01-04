package org.example.task2_walkFileTree;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

// Files обладает способом обхода дерева каталогов. Более подробно можно об этом почитать в статье
// https://habr.com/ru/articles/437694/.
// Создайте программу, которая будет принимать путь к существующей папке на Вашем компьютере. После этого программа
// должна вывести имена файлов и папок на каждом уровне, начиная с текущей папки до корня дерева (диска C или другого
// диска).
public class Task2 {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java Task2 <путь к папке>");
            return;
        }
        Path startingPath = Paths.get(args[0]);
        try {
            Files.walkFileTree(startingPath, new SimpleFileVisitor<>() {
                int depth = 0;

                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
                    printWithDepth(dir.getFileName().toString());
                    depth++;
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                    printWithDepth(file.getFileName().toString());
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
                    depth--;
                    return FileVisitResult.CONTINUE;
                }

                private void printWithDepth(String name) {
                    for (int i = 0; i < depth; i++) {
                        System.out.print("\t");
                    }
                    System.out.println(name);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
