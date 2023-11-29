package org.example.dz_2023_11_16.task1;

import java.awt.dnd.InvalidDnDOperationException;

public class Main {
    public static void main(String[] args) {
        System.out.println(weekday1(2));
        System.out.println(weekday2(2));
    }

    // weekday1 имеет более явное и структурированное представление кода с использованием switch-case.
// Этот метод может быть более читаемым, особенно когда количество случаев (дней недели) ограничено
// и известно заранее.
    public static String weekday1(int day) {
        switch (day) {
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
            case 7:
                return "Sunday";
            default:
                throw new InvalidDnDOperationException("day must be in range 1 to 7");
        }
    }

    // weekday2 использует массив и индексацию для получения названия дня недели,
    // что позволяет избежать дублирования кода. Он может быть удобен, если в программе часто требуется
    // доступ к названиям дней недели, и для этого используется массив.

    public static String weekday2(int day) {
        if ((day < 1) || (day > 7)) throw new InvalidDnDOperationException("day must be in range 1 to 7");
        String[] days = {
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday"
        };
        return days[day - 1];
    }
}
