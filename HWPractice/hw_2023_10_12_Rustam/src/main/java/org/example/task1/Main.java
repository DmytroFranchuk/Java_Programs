package org.example.task1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

// Что такое Stream?
// Что входит в пакет IO?
// Что позволяет делать класс File?
// Почему появился Path?
// Напишите программу, которая будет создавать и писать в файл какое-нибудь стихотворение.
// Напишите программу, которая будет считывать файл (скачайте файл результаты матчей)
// Match(year, month, day, firstTeam, firstTeamCount, secondTeamCount, secondTeam, watchers, stadium)
// Там где значения строки NULL - заведите специальную переменную строку String NULL_VALUE = "NULL";
// она должна быть константой. Там где значения NULL не заполняйте соответствующие поля матчей
// Необходимо создать файл FC Augsburg.txt с результатами матча этой команды
// записать в файл все матчи проходившие на Mercedes-Benz Arena
// записать в файл winners.txt победителя каждого матча, если ничья, то так и писать ничья
// Задачка со звездочкой - вывести файл table.txt информацию какая команда сколько забила мячей
public class Main {
    public static void main(String[] args) {
        String poem = "Тучки небесные, вечные странники!\n" +
                "Степью лазурною, цепью жемчужною\n" +
                "Мчитесь вы, будто как я же, изгнанники\n" +
                "С милого севера в сторону южную.\n" + "\n" +
                "Кто же вас гонит: судьбы ли решение?\n" +
                "Зависть ли тайная? злоба ль открытая?\n" +
                "Или на вас тяготит преступление?\n" +
                "Или друзей клевета ядовитая?\n" + "\n" +
                "Нет, вам наскучили нивы бесплодные…\n" +
                "Чужды вам страсти и чужды страдания;\n" +
                "Вечно холодные, вечно свободные,\n" +
                "Нет у вас родины, нет вам изгнания.";
        String fileName = "lermontov_poem.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(poem);
            System.out.println("Строки стихотворения записаны в файл: " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }




    }
}