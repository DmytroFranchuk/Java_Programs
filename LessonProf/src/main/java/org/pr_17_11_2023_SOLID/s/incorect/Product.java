package org.pr_17_11_2023_SOLID.s.incorect;

public class Product {
    private String name;
    private String article;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setArticle(String article) {
        this.article = article;
    }
}
