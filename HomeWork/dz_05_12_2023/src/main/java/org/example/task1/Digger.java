package org.example.task1;

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
        if (trench.getCurrentLength() < trench.getTargetLength()) {
            trench.setCurrentLength(trench.getCurrentLength() + 1);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Thread: " + this.getName() + " dig " + trench.getCurrentLength());
        return trench.getTargetLength();
    }
}
