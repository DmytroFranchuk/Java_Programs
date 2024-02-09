package org.example.dto;

public record Product(int id, String name) {
    @Override
    public String toString() {
        return "\nProduct{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
