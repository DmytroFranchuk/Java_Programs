package org.example.level1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task4 {
    public static void main(String[] args) {
        String[] str = "Carrot Collapse /\\ Criteria, Avatar. Sort][Cabbage".split("");

        Pattern pattern = Pattern.compile("[^a-zA-Z\s]");
        Matcher matcher;
        for (int i = 0; i < str.length; i++) {
            matcher = pattern.matcher(str[i]);
            if (matcher.find())
                System.out.println("номер позиции символа " + str[i] + ": " + i);
        }

    }
}

//В строке Carrot Collapse /\ Criteria, Avatar. Sort][Cabbage нужно найти позиции небуквенных символов
