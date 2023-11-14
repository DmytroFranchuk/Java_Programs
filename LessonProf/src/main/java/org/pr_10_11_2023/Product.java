package org.pr_10_11_2023;

import java.util.Objects;

public class Product {
    private int id;
    private String article;
    private boolean isActive;
    private String name;
    private double price;
    private String supplier;

    public Product(String name, double price, String supplier) {
        this.isActive = true;
        this.name = name;
        this.price = price;
        this.supplier = supplier;
    }

    public int getId() {
        return id;
    }

    public String getArticle() {
        return article;
    }

    public boolean isActive() {
        return isActive;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && isActive == product.isActive && Double.compare(price, product.price) == 0 &&
                Objects.equals(article, product.article) && Objects.equals(name, product.name) &&
                Objects.equals(supplier, product.supplier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, article, isActive, name, price, supplier);
    }

    @Override
    public String toString() {
        return String.format("Продукт: ИД - %d, наименование - %s, цена - %.2f, поставщик - %s, артикул - %s, активный - %s.",
                id, name, price, supplier, article, isActive ? "да" : "нет");
    }
}
