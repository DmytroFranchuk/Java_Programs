package org.pr_2023_11_17_SOLID.s.correct.service;

import org.pr_2023_11_17_SOLID.s.correct.model.Product;

public class ProductService {
    public void generateArticle(Product product) {
        product.setArticle("A-"+product.getName());
    }
}
