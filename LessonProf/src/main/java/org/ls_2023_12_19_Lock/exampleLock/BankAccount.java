
package org.ls_2023_12_19_Lock.exampleLock;

import lombok.Getter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    @Getter
    private int balance;
    private Lock lock;

    public BankAccount() {
        this.balance = 10_000;
        this.lock = new ReentrantLock();
    }

    public void withdraw(int sum) {
        lock.lock();
        try {
            if (balance >= sum) {
                balance -= sum;
                System.out.println(Thread.currentThread().getId() + " Сняли в банкомате " + sum + " остаток " + balance);
            } else {
                System.out.println(Thread.currentThread().getId() + " Недостаточно средств на счете" + " остаток " + balance);
            }
        } finally {
            lock.unlock();
        }
    }

    public void deposit(int sum) {
        lock.lock();
        try {
            if (sum > 0) {
                balance += sum;
                System.out.println(Thread.currentThread().getId() + " Внесена сумма в банкомат " + sum + " остаток " + balance);
            } else {
                System.out.println(Thread.currentThread().getId() + " Указана неверная сумма" + " остаток " + balance);
            }
        } finally {
            lock.unlock();
        }
    }

}
