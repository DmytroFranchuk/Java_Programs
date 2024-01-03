package org.example.level1;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3 {
    public static void main(String[] args) {
        String str = "Carrot Collapse /\\ Criteria, Avatar. Sort][Cabbage";
        str = str.replace(",", " ");
        str = str.replace(".", " ");
        str = str.replace("][", " ");
        String[] arrStr = str.split(" ");
        System.out.println(Arrays.toString(arrStr));

        Pattern pattern = Pattern.compile("^C.+[et]$");
        for (int i = 0; i < arrStr.length; i++) {
            Matcher matcher = pattern.matcher(arrStr[i].trim());
            if (matcher.find())
                System.out.println(arrStr[i]);
        }
    }
}
//Есть строка Carrot Collapse /\ Criteria, Avatar. Sort][Cabbage, необходимо написать регулярное выражение, которое
//будет находить все слова начинающиеся на C и заканчивающийся на t или e
