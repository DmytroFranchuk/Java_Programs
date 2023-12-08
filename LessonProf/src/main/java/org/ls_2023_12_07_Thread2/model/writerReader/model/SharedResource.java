package org.ls_2023_12_07_Thread2.model.writerReader.model;

public class SharedResource {
    private int data = 0;
    private int readersCount = 0;

    public synchronized void startReading() throws InterruptedException {
        while (readersCount > 0) {
            // Если есть активные писатели, ждем
            wait();
        }
        readersCount++;
    }

    public synchronized void endReading() {
        readersCount--;
        notifyAll(); // Сигнализируем другим читателям или писателям
    }

    public synchronized void startWriting() throws InterruptedException {
        while (readersCount > 0) {
            // Если есть активные читатели, ждем
            wait();
        }
    }

    public synchronized void endWriting() {
        notifyAll(); // Сигнализируем другим читателям или писателям
    }

    public int readData() {
        return data;
    }

    public void writeData(int value) {
        data = value;
    }
}
