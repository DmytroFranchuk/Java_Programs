package org.pr_17_11_2023_SOLID.s.correct.service;

import org.pr_17_11_2023_SOLID.s.correct.model.Product;

public class ProductService {
    public void generateArticle(Product product) {
        product.setArticle("A-"+product.getName());
    }
}
