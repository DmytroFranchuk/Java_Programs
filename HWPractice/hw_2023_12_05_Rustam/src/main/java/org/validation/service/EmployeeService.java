package org.validation.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.validation.repository.EmployeeRepository;
import org.validation.domain.Employee;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee saveOrUpdateEmployee(Employee employee) {
        return employeeRepository.findById(employee.getId())
                .map(existingEmployee -> {
                    // Если существует, обновляем существующего сотрудника
                    BeanUtils.copyProperties(employee, existingEmployee, "id");
                    return employeeRepository.save(existingEmployee);
                })
                .orElseGet(() -> {
                    // Если не существует, сохраняем нового сотрудника
                    return employeeRepository.save(employee);
                });
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}