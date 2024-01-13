package org.example.task2;

import org.example.task2.config.AppConfig;
import org.example.task2.model.CartItem;
import org.example.task2.model.Client;
import org.example.task2.model.Product;
import org.example.task2.model.ShoppingCart;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ShoppingApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Product laptop = new Product("1", "Laptop", 999.99);
        Product smartphone = new Product("2", "Smartphone", 499.99);
        Client client = new Client("121", "John Grosser");

        ShoppingCart shoppingCart = context.getBean(ShoppingCart.class);
        shoppingCart.addItem(new CartItem(laptop, 2));
        shoppingCart.addItem(new CartItem(smartphone, 1));

        System.out.println("Shopping Cart Contents:");
        for (CartItem item : shoppingCart.getItems()) {
            System.out.printf("Product: %s, Quantity: %d%n", item.getProduct().getName(), item.getQuantity());
        }
        context.close();
    }
}
