package org.validation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.validation.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}