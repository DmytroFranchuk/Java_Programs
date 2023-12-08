package org.ls_2023_12_07_Thread2.model2_ReaderWriter;

import java.time.LocalDateTime;

public class Writer extends Thread {
    private final Database database;
    private final LocalDateTime newData;

    public Writer(Database database, LocalDateTime newData) {
        this.database = database;
        this.newData = newData;
    }

    @Override
    public void run() {
        database.writeData(newData);
        System.out.println("Писатель записал новые данные: " + newData);
    }
}
