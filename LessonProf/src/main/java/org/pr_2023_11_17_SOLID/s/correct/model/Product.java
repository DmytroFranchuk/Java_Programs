package org.pr_2023_11_17_SOLID.s.correct.model;

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
