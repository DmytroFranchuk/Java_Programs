package org.pr_2023_11_17_SOLID.l.correct;

public class PrivilegedCustomer extends Customer{
    public PrivilegedCustomer(int age) {
        super(age);
    }
    public void applyDiscount() {
        System.out.println("Скидка применена!");
    }

    @Override
    public void buyProducts() {
        applyDiscount();
        super.buyProducts();
    }
}
