package org.example.task1;

import java.time.LocalDateTime;

public class Digger extends Thread {
    private Trench trench;

    public Digger(Trench trench) {
        this.trench = trench;
        this.start();
    }

    @Override
    public void run() {
        while (trench.getCurrentLength() != trench.getTargetLength()) {
            this.digTrench();
        }
    }

    public double digTrench(){
        double start = 0;
        if (trench.getCurrentLength() < trench.getTargetLength()) {
            trench.setCurrentLength(trench.getCurrentLength() + 1);
            start = System.currentTimeMillis() / 1_000;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.printf("Thread: %s dig %s : %.2f%n", this.getName(), trench.getCurrentLength(), start);
        return trench.getTargetLength();
    }
}
