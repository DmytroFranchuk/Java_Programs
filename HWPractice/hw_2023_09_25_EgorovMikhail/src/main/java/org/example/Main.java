package org.example;

public class Main {
    public static void main(String[] args) {
        String originalText = "MAMA MYLA RAMU";
        String encryptedText = encryptText(originalText);
        System.out.println("Original text: " + originalText);
        System.out.println("Encrypted text: " + encryptedText);
    }

    public static String encryptText(String text) {
        // Простой алгоритм шифрования - сдвиг символов на фиксированное количество позиций в кодировке Unicode
        int shift = 3; // Количество позиций для сдвига
        StringBuilder encrypted = new StringBuilder();

        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                int originalAlphabetPosition = character - 'A';
                int newAlphabetPosition = (originalAlphabetPosition + shift) % 26;
                char newCharacter = (char) ('A' + newAlphabetPosition);
                encrypted.append(newCharacter);
            } else {
                encrypted.append(character);
            }
        }
        return encrypted.toString();
    }
}