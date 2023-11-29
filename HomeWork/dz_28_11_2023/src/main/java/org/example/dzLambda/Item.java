package org.example.dzLambda;

public record Item(String nameProduct, double costProduct) {
    public Item(String nameProduct, double costProduct) {
        this.nameProduct = nameProduct;
        this.costProduct = costProduct;
    }
}
