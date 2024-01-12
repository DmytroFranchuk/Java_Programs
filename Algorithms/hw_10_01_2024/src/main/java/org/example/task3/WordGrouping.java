package org.example.task3;

import java.util.*;
import java.util.stream.Collectors;

// Сгруппируйте слова с одинаковым набором символов
// Дан список слов со строчными буквами. Реализуйте функцию поиска всех слов с одинаковым
// уникальным набором символов в слове
//
//Input: String words[] = {"student", "students", "dog", "god", "cat", "act", "flow", "wolf", "tact"};
//Output :
//student, students
//cat, act, tact
//dog, god
//flow, wolf
//(Набор букв 1 группы: s, t, u, d, e, n, t; 2 группы: a, c, t; 3 группы: d, o, g; 4 группы: f, l, o, w)
//Группы слов функция возвращает в виде List>, либо сразу печатает в консоль.
public class WordGrouping {
    public static void main(String[] args) {
        String words[] = {"student", "students", "dog", "god", "cat", "act", "flow", "wolf", "tact"};
        Map<String, List<String>> groupedByUniqueChars = groupWordsByUniqueChars(words);
        printGroupedWords(groupedByUniqueChars);
    }

    public static Map<String, List<String>> groupWordsByUniqueChars(String[] words) {
        return Arrays.stream(words)
                .collect(Collectors.groupingBy(
                        WordGrouping::getUniqueChars
                ));
    }

    private static String getUniqueChars(String word) {
        return Arrays.stream(word.split(""))
                .distinct()
                .sorted()
                .collect(Collectors.joining());
    }

    public static void printGroupedWords(Map<String, List<String>> groupedWords) {
        groupedWords.forEach((key, value) -> {
            System.out.println(String.join(", ", value));
        });
    }
}