package org.example.task1_ForkJoinPool;

import com.github.javafaker.Faker;

public class FakerStringArrayGenerator {
    private static final int MIN_WORD_LENGTH = 5;
    private static final int MAX_WORD_LENGTH = 16;

    public static String[] generateRandomStrings(int size, int maxLength) {
        Faker faker = new Faker();
        String[] words = new String[size];
        for (int i = 0; i < words.length; i++) {
            int wordLength = faker.number().numberBetween(MIN_WORD_LENGTH, MAX_WORD_LENGTH);
            String word = null;
            switch (faker.number().numberBetween(1, 6)) {
                case 1:
                    word = faker.company().profession();
                    break;
                case 2:
                    word = faker.medical().diseaseName();
                    break;
                case 3:
                    word = faker.job().position();
                    break;
                case 4:
                    word = faker.currency().name();
                    break;
                case 5:
                    word = faker.commerce().material();
                    break;
                case 6:
                    word = faker.finance().creditCard();
                    break;
            }
            words[i] = word;
        }
        return words;
    }
}
