package de.telran.bankapp.repository;

import de.telran.bankapp.entity.Account;
import de.telran.bankapp.entity.Agreement;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
