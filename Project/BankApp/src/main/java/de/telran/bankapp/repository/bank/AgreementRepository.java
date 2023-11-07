package de.telran.bankapp.repository.bank;

import de.telran.bankapp.entity.bank.Agreement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgreementRepository extends JpaRepository<Agreement, Long> {
}
