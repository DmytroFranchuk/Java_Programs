package org.ls_2023_12_07_Thread2.model.producerConsumer.model;

import org.ls_2023_12_07_Thread2.model.producerConsumer.model.Buffer;

public class Consumer extends Thread {
    private final Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                buffer.consume();
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
