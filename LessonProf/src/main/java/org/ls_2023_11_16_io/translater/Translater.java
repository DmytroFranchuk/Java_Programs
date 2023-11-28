package org.ls_2023_11_16_io.translater;

import java.util.HashMap;
import java.util.Map;

public class Translater {
    private Map<String, String> wordToTranslation;

    public Translater(Map<String, String> wordToTranslation) {
        this.wordToTranslation = wordToTranslation;
    }

    public Translater() {
        wordToTranslation = new HashMap<>();
    }

    public String translate(String original) {
        return wordToTranslation.get(original);
    }

    public boolean hasWord(String word) {
        return wordToTranslation.containsKey(word);
    }

    public void addWord(String original, String translation) {
        if (!wordToTranslation.containsKey(original)) {
            wordToTranslation.put(original, translation);
        }
    }
}
