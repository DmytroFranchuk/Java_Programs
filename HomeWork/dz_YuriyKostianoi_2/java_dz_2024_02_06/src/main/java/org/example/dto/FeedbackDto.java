package org.example.dto;

public class FeedbackDto {
    private String nameProduct;
    private int rating;
    private String message;

    public FeedbackDto() {
    }

    public FeedbackDto(String nameProduct, int rating, String message) {
        this.nameProduct = nameProduct;
        this.rating = rating;
        this.message = message;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public int getRating() {
        return rating;
    }

    public String getMessage() {
        return message;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "\nFeedbackDto{" +
                "nameProduct='" + nameProduct + '\'' +
                ", rating=" + rating +
                ", message='" + message + '\'' +
                '}';
    }
}
