package org.example.level2;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3 {
    public static void main(String[] args) {
        Scanner sc;
        List<String> list= new ArrayList<>();

        try {
            FileReader fileReader = new FileReader("test-data.json");
            sc = new Scanner(fileReader);
            while (sc.hasNextLine()){
                list.add(sc.nextLine());
            }
            fileReader.close();
            sc.close();

            System.out.println("Названия boolean переменных: " + booleanName(list));
            System.out.println("Версия: " + getVersion(list));
            System.out.println("Строка с полем normalizer: " + getStrWithNormalizer(list));

        }catch (IOException exception){
            exception.printStackTrace();
        }
    }

    private static List<String> booleanName (List<String> list){
        List<String> name  = new ArrayList<>();
        String[] arrStr;
        String str;
        Pattern p1 = Pattern.compile("(true|false)");
        for (String e : list) {
            Matcher m1 = p1.matcher(e);
            if (m1.find()) {
                arrStr = e.split(":");
                str = arrStr[0].trim();
                name.add(str.substring(1, str.length() - 1));
            }
      }
    return name;
    }

    private static String getVersion(List<String> list){
        String[] arrStr;
        String str;
        String version = "";
        Pattern p2 = Pattern.compile("(version)");
        for (String e : list) {
            Matcher m2 = p2.matcher(e);
            if (m2.find()) {
                arrStr = e.split(":");
                str = arrStr[1].trim();
                version = str.substring(0, str.length() - 1);
            }
        }
        return version;
    }

    private static String getStrWithNormalizer(List<String> list){
        Pattern p3 = Pattern.compile("(normalizer)");
        StringBuilder startStr = new StringBuilder();
        boolean isEnd = false;
        int countBracket=0;
        for (String e : list) {
            Matcher m3 = p3.matcher(e);
            if (m3.find()) {
                startStr.append(e);
                countBracket++;
            }
            else if (startStr.length()>0 && !isEnd){
                if (e.contains("}")){
                    countBracket--;
                    if (countBracket <= 0) isEnd = true;
                }
                startStr.append(e);
            }
        }
        return startStr.toString();
    }

}
//Дан файл. C посощью регулярных выражений найдите
//- Названия всех boolean переменных
//- Версию приложения (версия - любое число, находится в поле version)
//- Все поля (поле - строка, которая начинается с { и заканчивается }), в названии которых есть слово normalizer