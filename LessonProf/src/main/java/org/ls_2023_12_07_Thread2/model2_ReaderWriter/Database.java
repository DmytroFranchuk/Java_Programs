package org.ls_2023_12_07_Thread2.model2_ReaderWriter;

import java.time.LocalDateTime;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Database {
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Data data = new Data();

    public LocalDateTime readData() {
        lock.readLock().lock();
        try {
            return data.getLocalDateTime();
        } finally {
            lock.readLock().unlock();
        }
    }

    public void writeData(LocalDateTime newData) {
        lock.writeLock().lock();
        try {
            data.setLocalDateTime(newData); // Устанавливаем новое значение
        } finally {
            lock.writeLock().unlock();
        }
    }


}
