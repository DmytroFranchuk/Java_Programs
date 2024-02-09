package org.example.dto;

public record Feedback(int id, Product product, int rating, String message) {
    @Override
    public String toString() {
        return "\nFeedback{" +
                "id=" + id +
                ", product=" + product +
                ", rating=" + rating +
                ", message='" + message + '\'' +
                '}';
    }
}
