package org.example;

public class Consumer extends Thread {
    private final Storage storage;
    private final int consumerCount;
    private final int consumerTime;
    private final String consumerId;
    private static int countId = 0;

    public Consumer(Storage storage) {
        this.storage = storage;
        this.consumerCount = 3;
        this.consumerTime = 4000;
        this.consumerId = "consumerId_" + ++countId;
        this.setName(consumerId);
    }

    public String getConsumerId() {
        return consumerId;
    }

    @Override
    public void run() {
        try {
            sleep(consumerTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            storage.remove(this.getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
