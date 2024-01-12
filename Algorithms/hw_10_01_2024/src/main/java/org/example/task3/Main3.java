package org.example.task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main3 {
        public static void main(String[] args) {
            String words[] = {"student", "students", "dog", "god", "cat", "act", "flow", "wolf", "tact"};
            Map<String, List<String>> groupedByUniqueChars = groupWordsByUniqueChars(words);
            printGroupedWords(groupedByUniqueChars);
        }

        public static Map<String, List<String>> groupWordsByUniqueChars(String[] words) {
            Map<String, List<String>> groupedWords = new HashMap<>();
            for (String word : words) {
                String uniqueChars = getUniqueChars(word);

                if (!groupedWords.containsKey(uniqueChars)) {
                    groupedWords.put(uniqueChars, new ArrayList<>());
                }

                groupedWords.get(uniqueChars).add(word);
            }

            return groupedWords;
        }

        private static String getUniqueChars(String word) {
            StringBuilder uniqueChars = new StringBuilder();
            for (char c : word.toCharArray()) {
                if (uniqueChars.indexOf(String.valueOf(c)) == -1) {
                    uniqueChars.append(c);
                }
            }
            return uniqueChars.toString();
        }

        public static void printGroupedWords(Map<String, List<String>> groupedWords) {
            for (List<String> group : groupedWords.values()) {
                System.out.println(String.join(", ", group));
            }
        }
    }
