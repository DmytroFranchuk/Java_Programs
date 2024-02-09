package org.example.services;

import org.example.dto.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private static int value = 0;
    private final List<Product> products;

    public ProductService() {
        products = new ArrayList<>();
        products.add(new Product(value++, "Toyota Land Cruiser Prado"));
        products.add(new Product(value++, "Toyota RAV4 Plug-in"));
        products.add(new Product(value++, "Toyota Highlander"));
        products.add(new Product(value++, "Toyota Hilux 2.8"));
        products.add(new Product(value++, "Toyota LC Prado"));
        System.out.println(products);
        value = 0;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product getProductById(int productId) {
        return products.stream()
                .filter(product -> product.id() == productId)
                .findFirst()
                .orElse(null);
    }

    public Product getProductByName(String productName) {
        return products.stream()
                .filter(product -> productName.equals(product.name()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        return "\nProductService{" +
                "products=" + products +
                '}';
    }
}
