package com.example.lesson_2024_01_23.task3_Primary;

import com.example.lesson_2024_01_23.task3_Primary.season.Config;
import com.example.lesson_2024_01_23.task3_Primary.season.Season;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Создайте бин Снег в классе конфигурации. Внедрите бин Снег в бин класса Зима,
// имплементирующий интерфейс Сезон.

// Дополните предыдущее задание. Создайте также бины классов Лето, Весна, Осень,
// имплементирующие интерфейс Сезон. Создайте бин Текущий сезон, который хранит текущий сезон
// года (когда бы ни запускалась программа, сезон должен быть правильный).
// Создайте бин Туристический сезон – каждый новый туристический сезон должен начинаться с
// Зимы (используйте @Primary). Создайте бин класса Год и внедрите в него все 4 сезона года.

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new
                AnnotationConfigApplicationContext(Config.class);
        Season season = context.getBean(Season.class);
        System.out.println(season);
        System.out.println();
        Season currentSeason = context.getBean("currentSeason", Season.class);
        System.out.println(currentSeason);
        context.close();
    }
}
