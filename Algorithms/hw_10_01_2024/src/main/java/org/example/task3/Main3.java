package org.example.task3;

import java.util.*;

public class Main3 {
    private static int groupNumber = 1;
    public static void main(String[] args) {
        String words[] = {"student", "students", "dog", "god", "cat", "act", "flow", "wolf", "tact"};
        Map<String, List<String>> groupedByUniqueChars = groupWordsByUniqueChars(words);
        printGroupedWords(groupedByUniqueChars);
    }

    public static Map<String, List<String>> groupWordsByUniqueChars(String[] words) {
        Map<String, List<String>> groupedByUniqueChars = new HashMap<>();
        for (String word : words) {
            String uniqueChars = getUniqueChars(word);
            groupedByUniqueChars.computeIfAbsent(uniqueChars, k -> new ArrayList<>()).add(word);
        }
        return groupedByUniqueChars;
    }

    private static String getUniqueChars(String word) {
        char[] charArray = word.toCharArray();
        Arrays.sort(charArray);
        StringBuilder uniqueChars = new StringBuilder();
        for (int i = 0; i < charArray.length - 1; i++) {
            if (charArray[i] != charArray[i + 1]) {
                uniqueChars.append(charArray[i]);
            }
        }
        uniqueChars.append(charArray[charArray.length - 1]);
        return uniqueChars.toString();
    }

    public static void printGroupedWords(Map<String, List<String>> groupedWords) {
        for (Map.Entry<String, List<String>> entry : groupedWords.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            System.out.println("Группа " + groupNumber++ + ": " + String.join(", ", value));
        }
    }
    }
