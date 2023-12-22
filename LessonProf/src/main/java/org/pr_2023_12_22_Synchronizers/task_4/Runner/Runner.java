package org.pr_2023_12_22_Synchronizers.task_4.Runner;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadLocalRandom;

public class Runner implements Runnable {
    protected final int id;
    protected final int teamNum;
    protected final SynchronousQueue<Baton> hand;
    protected final Runner next;

    public Runner(int id, int teamNum, Runner next) {
        this.id = id;
        this.teamNum = teamNum;
        this.next = next;
        this.hand = new SynchronousQueue<>();
    }

    protected void giveButon(Baton baton) throws InterruptedException {
        if (next == null) {
            System.out.printf("Team %d: Runner %d finished %n", teamNum, id);
            return;
        }
        next.hand.put(baton);
        System.out.printf("Team %d: Runner %d give baton to %d %n", teamNum, id, next.id);
    }

    @Override
    public void run() {
        try {
            Baton baton = hand.take();
            System.out.printf("Team %d: Runner %d is running %n", teamNum, id);
            Thread.sleep(ThreadLocalRandom.current().nextInt(2000));
            giveButon(baton);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
