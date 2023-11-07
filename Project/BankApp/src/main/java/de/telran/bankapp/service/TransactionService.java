package de.telran.bankapp.service;

import de.telran.bankapp.entity.bank.Transaction;

import java.util.List;

public interface TransactionService {
    List<Transaction> getAll();
}
