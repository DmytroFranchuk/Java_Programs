package org.ls_2023_12_07_Thread2.model2_ReaderWriter;

// Вы разрабатываете систему управления информацией в базе данных.
// Реализуйте модель "читатели-писатели" для безопасного доступа к данным.
// Создайте классы Database, Reader, и Writer.
// Читатели считывают данные из базы, а писатели записывают новые данные.

import java.time.LocalDateTime;


public class Main {
    public static void main(String[] args) {

        Database database = new Database();

        // Создаем писателя
        LocalDateTime newData = LocalDateTime.now();
        Writer writer = new Writer(database, newData);
        writer.start();

        // Создаем читателей
        for (int i = 0; i < 5; i++) {
            Reader reader = new Reader(database);
            reader.start();
        }
    }
}



