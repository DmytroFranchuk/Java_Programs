package org.ls_2023_12_12_concurrent.task2;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Bank {
    ConcurrentMap<String, Double> numberToBalance = new ConcurrentHashMap<>();

    public Double getBalance(String numberAccount) {
        return numberToBalance.getOrDefault(numberAccount, 0.0);
    }

    public void deposit(String numberAccount, double sum) {
        numberToBalance.merge(numberAccount, sum, Double::sum);
    }

}
