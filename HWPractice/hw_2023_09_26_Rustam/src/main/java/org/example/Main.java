package org.example;

public class Main {
    public static void main(String[] args) {
        // Переделайте MyLinkedList из одной из предыдущих домашек, чтобы он был generic class
        // Напишите класс Database (который в качестве хранения использует Map<K,V>),
        // база должна быть параметризована двумя параметрами - ключ и значение,
        // ограничение - ключ должен быть наследником Number

        Database<Integer, String> database = new Database<>();
        database.addData(1, "Value 1");
        database.addData(2, "Value 2");
        System.out.println(database.getValue(1));
    }
}