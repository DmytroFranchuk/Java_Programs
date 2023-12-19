package org.ls_2023_12_19_Lock.exampleLock;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        Arrays.stream(new int[2])
                .mapToObj(e -> new Thread(new ATM(bankAccount)))
                .forEach(Thread::start);
    }
}
