package de.telran.bankapp.repository.bank;

import de.telran.bankapp.entity.bank.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
