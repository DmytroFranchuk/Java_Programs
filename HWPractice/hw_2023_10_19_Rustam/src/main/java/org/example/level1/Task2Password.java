package org.example.level1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2Password {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your password: ");
        String pass;
        do{
           pass = scanner.nextLine();
        }while (!isCorrectPassword(pass));
        System.out.println("ваш пароль надежный ");
    }

    private static boolean isCorrectPassword(String pass){
        //- хотя бы 1 символ латинского алфавита в нижнем регистрe
        Pattern p1 = Pattern.compile("[a-z]");
        Matcher m1 = p1.matcher(pass);
        if (!m1.find()){
            System.out.println("должен быть хотя бы 1 символ латинского алфавита в нижнем регистре ");
            return false;
        }
        //- хотя бы 1 символ латинского алфавита в верхнем регистре
        Pattern p2 = Pattern.compile("[A-Z]");
        Matcher m2 = p2.matcher(pass);
        if (!m2.find()){
            System.out.println("должен быть хотя бы 1 символ латинского алфавита в верхнем регистре ");
            return false;
        }
        //- хотя бы 1 символ числа
        Pattern p3 = Pattern.compile("[1-9]");
        Matcher m3 =p3.matcher(pass);
        if (!m3.find()){
            System.out.println("должен быть хотя бы 1 символ числа ");
            return false;
        }
        //- хотя бы 1 символ !"#$%&'()*+,-./:;<=>?@[\]^_{|}~
        Pattern p4 = Pattern.compile("[!\"#$%&'()*+,-./:;<=>?@^_{|}~\\[\\]]");
        Matcher m4 =p4.matcher(pass);
        if (!m4.find()){
            System.out.println("должен быть хотя бы 1 символ из следующего перечня !\"#$%&'()*+,-./:;<=>?@[\\]^_{|}~ ");
            return false;
        }
        //- длина не меньше 8 символов
        Pattern p5 = Pattern.compile(".{8,}");
        Matcher m5 =p5.matcher(pass);
        if (!m5.find()){
            System.out.println("длина пароля должна быть не меньше 8 символов ");
            return false;
        }
        return true;
    }
}
//Напишите программу, которая используя регулярные выражения будет проверять пароль на надежность:
//- хотя бы 1 символ латинского алфавита в нижнем регистре
//- хотя бы 1 символ латинского алфавита в верхнем регистре
//- хотя бы 1 символ числа
//- хотя бы 1 символ !"#$%&'()*+,-./:;<=>?@[\]^_{|}~
//- длина не меньше 8 символов