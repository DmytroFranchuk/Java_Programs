package org.pr_2023_11_17_SOLID.l.incorect;

public class NewCustomer extends Customer {
    public NewCustomer(int age) {
        super(age);
    }

    @Override
    public void applyDiscount() {
        throw new UnsupportedOperationException("Скидка не применима ");
    }
}
