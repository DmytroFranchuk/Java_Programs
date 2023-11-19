package org.pr_17_11_2023_SOLID.o.correct;

public class RetailProductService extends ProductService {
    @Override
    public void generateArticle(Product product) {
        product.setArticle("R-" + product.getName());
    }
}
