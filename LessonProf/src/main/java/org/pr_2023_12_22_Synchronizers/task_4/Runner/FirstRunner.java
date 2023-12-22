package org.pr_2023_12_22_Synchronizers.task_4.Runner;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadLocalRandom;

public class FirstRunner extends Runner {
    private final CyclicBarrier barrier;

    public FirstRunner(int id, int teamNum, Runner next, CyclicBarrier barrier) {
        super(id, teamNum, next);
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            barrier.await();
            System.out.printf("Team %d: Runner %d is running %n", teamNum, id);
            Thread.sleep(ThreadLocalRandom.current().nextInt(2000));
            giveButon(new Baton());
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}
