package org.pr_2023_11_17_SOLID.o.correct;

public class WholesaleProductService extends ProductService{
    @Override
    public void generateArticle(Product product) {
        product.setArticle("W-" + product.getName());
    }
}
