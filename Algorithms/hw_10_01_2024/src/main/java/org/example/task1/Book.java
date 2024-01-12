package org.example.task1;

import java.util.Objects;

public class Book implements Comparable<Book>{
    private String name;
    private double price;
    private boolean isPresent;

    public Book(String name, double price, boolean isPresent) {
        this.name = name;
        this.price = price;
        this.isPresent = isPresent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Double.compare(price, book.price) == 0 && isPresent == book.isPresent && Objects.equals(name, book.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, isPresent);
    }

    @Override
    public int compareTo(Book o) {
        int priceComparison = Double.compare(this.price, o.price);
        if (priceComparison == 0) {
            return this.name.compareTo(o.name);
        }
        return priceComparison;
    }
}
