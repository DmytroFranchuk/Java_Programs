package de.telran.bankapp.service;

import de.telran.bankapp.entity.bank.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAll();
}
