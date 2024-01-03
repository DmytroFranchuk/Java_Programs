package org.example.level2;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {
    public static void main(String[] args) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("matches.txt"));
            //--\\d{4}), (\\d{1,2}), (\\d{1,2}), (.*?), )
            Pattern pattern = Pattern.compile("^(\\d{4}), ([1-9]{1})([0-2]?), ([1-9]?)([0-9]?), (.*?), " +
                    "(\\d+:\\d+), (.*?), (NULL|\\d+), (NULL|\\.*?)");
            int nomStrInFile = 0;
            int nomStr = 0;
            while (reader.ready()){
                 String str = reader.readLine();
                 nomStrInFile++;
                 Matcher matcher = pattern.matcher(str);
                 if (matcher.find()) {
                     System.out.println("Строка " + (++nomStr) + ":" + str);
                 }
            }
            reader.close();
            System.out.printf("В файле %d строк, прочитано %d строк",nomStrInFile,nomStr);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
//Из файла с результатом матчей попробуйте создать регулярное выражение, которому соответствует каждая строка
//2022, 1, 7, FC Bayern Munich, 1:2, Borussia Monchengladbach, NULL, NULL