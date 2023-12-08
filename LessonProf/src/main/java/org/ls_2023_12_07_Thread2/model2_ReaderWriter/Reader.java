package org.ls_2023_12_07_Thread2.model2_ReaderWriter;

import java.time.LocalDateTime;

public class Reader extends Thread {
    private final Database database;

    public Reader(Database database) {
        this.database = database;
    }

    @Override
    public void run() {
        LocalDateTime data = database.readData();
        System.out.println("Читатель прочитал данные: " + data);
    }
}
