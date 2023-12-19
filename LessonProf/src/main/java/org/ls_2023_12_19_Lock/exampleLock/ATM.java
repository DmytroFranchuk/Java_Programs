package org.ls_2023_12_19_Lock.exampleLock;

import java.util.concurrent.ThreadLocalRandom;

public class ATM implements Runnable{
    private final BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            bankAccount.deposit(ThreadLocalRandom.current().nextInt(100));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            bankAccount.withdraw(ThreadLocalRandom.current().nextInt(700));
            bankAccount.deposit(ThreadLocalRandom.current().nextInt(500));
            bankAccount.withdraw(ThreadLocalRandom.current().nextInt(700));
            bankAccount.deposit(ThreadLocalRandom.current().nextInt(500));
        }
    }
}
