package org.pr_17_11_2023_SOLID.s.correct.service;

import org.pr_17_11_2023_SOLID.s.correct.model.Customer;

public class ValidationService {
    public boolean checkPassword(String password) {
        return password.length() >= 5;
    }

    public void checkAge(Customer customer) {
        if (customer.getAge() < 12) {
            System.out.println("Возраст слишком мал!");
        }
    }
}
