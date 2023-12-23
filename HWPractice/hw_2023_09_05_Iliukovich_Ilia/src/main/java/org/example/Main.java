package org.example;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Имеется класс Cat c полями:
        // public class Cat {
        //  private String name;
        //  private int age;
        //  private String colour;
        //  private boolean isHungry; }
        // На основе списка экземпляров данного класса List cats
        // Получить Map имя / информация, голодна ли кошка
        // Получить Map цвет / количество кошек данного цвета
        // Получить Map> цвет / список имен кошек данного цвета

        List<Cat> cats = List.of(
                new Cat("Мурзик", 2, "рыжий", true),
                new Cat("Вольт", 7, "серый", true),
                new Cat("Барсик", 3, "белый", false),
                new Cat("Маруся", 4, "черный", true),
                new Cat("Бублик", 4, "черный", false),
                new Cat("Урсула", 3, "рыжий", true)
        );
        Map<String, Boolean> nameToIsHungryMap = cats.stream()
                .collect(Collectors.toMap(Cat::getName, Cat::isHungry));
        System.out.println(nameToIsHungryMap);

        Map<String, Long> colourToCountMap = cats.stream()
                .collect(Collectors.groupingBy(Cat::getColour, Collectors.counting()));
        System.out.println(colourToCountMap);

        Map<String, List<String>> colourToNamesMap = cats.stream()
                .collect(Collectors.groupingBy(Cat::getColour, Collectors.mapping(Cat::getName, Collectors.toList())));
        System.out.println(colourToNamesMap);






















    }
}