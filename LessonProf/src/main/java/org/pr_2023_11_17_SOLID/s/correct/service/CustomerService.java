package org.pr_2023_11_17_SOLID.s.correct.service;

import org.pr_2023_11_17_SOLID.s.correct.model.Customer;
import org.pr_2023_11_17_SOLID.s.correct.model.Product;

public class CustomerService {
    public void addProduct(Customer customer, Product product) {
        customer.getProducts().add(product);
    }
}
