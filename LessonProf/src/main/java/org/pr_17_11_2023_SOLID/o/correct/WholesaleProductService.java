package org.pr_17_11_2023_SOLID.o.correct;

public class WholesaleProductService extends ProductService{
    @Override
    public void generateArticle(Product product) {
        product.setArticle("W-" + product.getName());
    }
}
