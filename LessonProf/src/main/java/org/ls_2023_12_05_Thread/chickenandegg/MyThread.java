package org.ls_2023_12_05_Thread.chickenandegg;

import org.ls_2023_12_05_Thread.chickenandegg.Chicken;
import org.ls_2023_12_05_Thread.chickenandegg.Egg;

public class MyThread {
    public static void main(String[] args) throws InterruptedException {

        //1 Напишите программу, которая определит, что появилось раньше – курица или яйцо.
        // Для этого создайте два класса – Курица и Яйцо, которые будут наследоваться от Thread
        // и выводить своё мнение в консоль после случайно заданной задержки.
        // Задержка устанавливается методом Thread.sleep(). В основной программе запустите оба потока.
        // Чьё слово будет первым, тот и победил. Чтобы поток main не завершился раньше дочерних потоков,
        // нужно у запускаемых потоков
        //2 Используя лямбда-выражения, создайте потоки, каждый из которых 10_000 раз выводит
        // в консоль число – свой номер по порядку запуска. Запустите в цикле 10 потоков.
        // Выводятся ли потоки по порядку? Что будет если добавить задержку запуска, равную 1 мс?

        Chicken chicken = new Chicken();
        Egg egg = new Egg();
        chicken.start();
        egg.start();
        System.out.println("Окончание программы");
        Thread.sleep(10000);
        egg.interrupt();
        chicken.interrupt();
        System.out.println("Окончание кода в программе");






    }
}
