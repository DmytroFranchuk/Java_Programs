package de.telran.bankapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Objects;

@AllArgsConstructor
@Getter
public class Product {
    private int id;
    private int manager_id;
    private String name;
    private Status status;
    private int currency_code;
    private double interest_rate;
    private Integer limit;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", manager_id=" + manager_id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", currency_code=" + currency_code +
                ", interest_rate=" + interest_rate +
                ", limit=" + limit +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
