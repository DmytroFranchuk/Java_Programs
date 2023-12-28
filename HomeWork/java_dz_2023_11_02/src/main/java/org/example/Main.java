package org.example;

// Создайте класс Велосипед. Типы полей этого класса должны быть объявлены как
// внутренние классы (руль, седло, колесо, передачи, рама и т.д.).
// Каждая часть велосипеда помимо описания характеристик хранит запас прочности.
// Когда запас прочности равен 0, часть велосипеда ломается.
// В основной программе создайте велосипед. Велосипед должен ехать и встречать на пути препятствия
// (яма, бордюр, битое стекло, лужа и т.д.). Каждое препятствие уменьшает показатель прочности на
// случайную величину у случайной части велосипеда. Программа выполняется, пока у велосипеда нет
// сломанных частей.

import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        Bicycle bicycle = new Bicycle();
        boolean allPartsBroken = true;
        while (allPartsBroken) {
            Thread.sleep(200);
            int partIndex = random.nextInt(5);
            switch (partIndex) {
                case 0:
                    if (!bicycle.useHandlebar(random.nextInt(5) + 1)) allPartsBroken = false;
                    break;
                case 1:
                    if (!bicycle.useSaddle(random.nextInt(5) + 1)) allPartsBroken = false;
                    break;
                case 2:
                    if (!bicycle.useWheel(random.nextInt(5) + 1)) allPartsBroken = false;
                    break;
                case 3:
                    if (!bicycle.useGears(random.nextInt(5) + 1)) allPartsBroken = false;
                    break;
                case 4:
                    if (!bicycle.useFrame(random.nextInt(5) + 1)) allPartsBroken = false;
                    break;
            }
        }
    }
}