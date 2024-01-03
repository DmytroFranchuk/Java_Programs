package org.example.level2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String email;
        Pattern pattern = Pattern.compile("([a-zA-Z0-9\\.]{1,30})@([a-zA-Z0-9\\.].*?)\\.[\\S]{2,4}$");
        Matcher matcher;
        boolean isCorrectEmail;
        do {
            System.out.print("Enter correct email ");
            email = scanner.nextLine();
            matcher = pattern.matcher(email);
            isCorrectEmail = matcher.find();
            if (!isCorrectEmail)
                System.out.println("not correct! enter again");
        } while (!isCorrectEmail);


    }
}
//Напишите проверку email на валидность мы не гонимся здесь за оригинальным стандартом (если интересно, то вот стандарт),
//наша задача сделать простую проерку
//- Имя email может содержать буквы и цифры латинского алфавита (максимум 30) и точку
//- После идет @
//- После может быть буквы, цифры и точка
//- После идет точка и от 2 до 4 символов P.S. будьте внимательны с символом точка
