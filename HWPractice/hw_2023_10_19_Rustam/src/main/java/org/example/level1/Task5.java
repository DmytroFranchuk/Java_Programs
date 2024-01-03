package org.example.level1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task5 {
    public static void main(String[] args) {
       String str = "01111000201010101701";
       Pattern pattern = Pattern.compile("[^01]");
        for (int i = 0; i < str.length(); i++) {
            Matcher matcher = pattern.matcher(""+str.charAt(i));
            if (matcher.find())
                System.out.println("Не двоичный символ: "+ str.charAt(i) + ". Индекс символа : " + i);
        }
    }
}
//Есть строка 01111000201010101701. С помощью регулярного выражения проверьте является ли данная строка двиочным
//представлением (двичное счисло может содержать только 1 и 0), если есть ошибка верните индексы, где они встретились