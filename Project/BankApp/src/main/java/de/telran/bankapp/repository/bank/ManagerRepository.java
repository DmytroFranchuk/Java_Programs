package de.telran.bankapp.repository.bank;

import de.telran.bankapp.entity.bank.Manager;
import de.telran.bankapp.entity.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Long> {

    void deleteManagerById(Long id);
    boolean existsByStatus(Status status);
}
