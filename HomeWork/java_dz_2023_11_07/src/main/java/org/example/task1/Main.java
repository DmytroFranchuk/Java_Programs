package org.example.task1;

import org.example.task1.ExampleLombok;

public class Main {
    public static void main(String[] args) {
        ExampleLombok eLombok = new ExampleLombok(12, "накопительный", true);
        ExampleLombok eLombok1 = new ExampleLombok(21, "накопительный", true);
        ExampleLombok eLombok2 = new ExampleLombok(21, "накопительный", true);
        System.out.println(eLombok.getSumma());
        System.out.println(eLombok.getCheck());
        System.out.println(eLombok.isValidation());
        eLombok.setSumma(100);
        eLombok.setCheck("дебетовый счет с кэшбэком на продукты");
        eLombok.setValidation(false);
        System.out.println(eLombok);
        System.out.println(eLombok.hashCode());
        System.out.println(eLombok.equals(eLombok1));
        System.out.println(eLombok1.canEqual(eLombok2));
    }
}