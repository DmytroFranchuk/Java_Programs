package org.example;

public class Manufacturer extends Thread {
    private final Storage storage;
    private final int producerCount;
    private final int producerTime;
    private final String producerId;
    private static int countId = 0;

    public Manufacturer(Storage storage) {
        this.storage = storage;
        this.producerCount = 3;
        this.producerTime = 2000;
        this.producerId = "producerId_" + ++countId;
        this.setName(producerId);
    }

    public String getProducerId() {
        return producerId;
    }

    @Override
    public void run() {
        try {
            sleep(producerTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            storage.add(this.getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
