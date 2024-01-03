package org.example.level1;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {
    public static void main(String[] args) {
        try {
            String str = readFile(new File("matches.txt"));
            String[] arrStr = str.split(",");
            Pattern pattern = Pattern.compile("^\\w+\\s\\w+$");

            for (int i = 3; i < arrStr.length; i+=7) {
                Matcher matcher = pattern.matcher(arrStr[i].trim());
                if (matcher.find()) {
                    System.out.println(arrStr[i]);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private static String readFile(File file) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder resultStr = new StringBuilder();
        while (true) {
            try {
                if (!reader.ready()) break;
                resultStr.append(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return resultStr.toString();
    }
}
//Считайте файл результаты матчей(из домашней работы 22) загрузите файл в строку(можно построчно считывать), и найдите
//в нем все названия команд, которые состоят из двух слов