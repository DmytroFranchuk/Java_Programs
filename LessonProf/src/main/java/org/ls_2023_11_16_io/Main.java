package org.ls_2023_11_16_io;

import org.ls_2023_11_16_io.translater.DictionaryReader;
import org.ls_2023_11_16_io.translater.Translater;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1 Создайте файл test.txt на компьютере. Внутри файла test.txt напишите несколько
        // слов – каждое слово на новой строке. С помощью класса Scanner прочитайте содержимое
        // файла, добавляя каждое прочитанное слово в список.

        Translater t = new Translater(DictionaryReader.read("C:\\Java\\2\\Java_Programs\\LessonProf\\src\\main\\java\\org\\ls_16_11_2023_io\\translater\\Dictonry.txt"));
        System.out.println(t.translate("director"));


        String strPath = "C:\\Java\\2\\Java_Programs\\LessonProf\\src\\main\\java\\org\\ls_16_11_2023_io\\test.txt";
        List<String> words = new ArrayList<>();
        try (Scanner sc = new Scanner(Path.of(strPath))) {
            while (sc.hasNextLine()) {
                words.add(sc.nextLine());
            }
        } catch (IOException e) {
            System.err.println(e);
        }
        System.out.println(words);

        writeWords(words, System.out);
        writeWords(words, new FileOutputStream("wordsTest2"));


    }

    // 2 Создайте метод, который принимает список слов и выходной поток в который нужно
    // выводить данные. Вызовите метод, передав в него поток вывода в консоль, затем повторите
    // вызов, передав в метод поток записи в файл.
    private static void writeWords(List<String> words, OutputStream output) {
//        try {
//            for (String w : words) {
//                output.write(w.getBytes(StandardCharsets.UTF_8));
//            }
//        } catch (IOException e) {
//            System.err.println(e);
//        } finally {
//            try {
//                output.close();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
        try(OutputStream output2 = new BufferedOutputStream(output)) {
            for (String w : words) {
                output2.write((w + " ").getBytes(StandardCharsets.UTF_8));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
