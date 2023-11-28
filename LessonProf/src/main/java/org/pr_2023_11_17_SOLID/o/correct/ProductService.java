package org.pr_2023_11_17_SOLID.o.correct;

public class ProductService {
    public void generateArticle(Product product) {
        product.setArticle("A-"+product.getName());
    }
}
