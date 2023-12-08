package org.ls_2023_12_07_Thread2.model.producerConsumer.model;

import org.ls_2023_12_07_Thread2.model.producerConsumer.model.Buffer;

public class Producer extends Thread {
    private final Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                buffer.produce(i);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
