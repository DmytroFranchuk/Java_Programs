package org.pr_17_11_2023_SOLID.o.correct;

public class ProductService {
    public void generateArticle(Product product) {
        product.setArticle("A-"+product.getName());
    }
}
