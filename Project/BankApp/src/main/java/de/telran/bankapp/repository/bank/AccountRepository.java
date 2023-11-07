package de.telran.bankapp.repository.bank;

import de.telran.bankapp.entity.bank.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
