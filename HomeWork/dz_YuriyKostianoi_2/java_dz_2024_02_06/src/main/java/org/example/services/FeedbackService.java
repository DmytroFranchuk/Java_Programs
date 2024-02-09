package org.example.services;

import org.example.dto.Feedback;
import org.example.dto.FeedbackDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class FeedbackService {
    private static int count = 0;
    private final List<Feedback> feedbacks;
    private final ProductService productService;

    public FeedbackService() {
        feedbacks = new ArrayList<>();
        productService = new ProductService();
        int size = productService.getProducts().size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 132; j++) {
                feedbacks.add(new Feedback(count++, productService.getProducts().get(i),
                        new Random().nextInt(5),
                        "Обратная связь о продукте: " + productService.getProducts().get(i).name()));
            }
        }
    }

    public void saveFeedback(FeedbackDto feedbackDto) {
        if (feedbackDto != null &&
                !feedbackDto.getMessage().isEmpty() &&
                (feedbackDto.getRating() >= 0 && feedbackDto.getRating() <= 5)) {
            Feedback feedback = new Feedback(count++, productService.getProductByName(feedbackDto.getNameProduct()),
                    feedbackDto.getRating(), feedbackDto.getMessage());
            feedbacks.add(feedback);
        }
    }

    public String averageRatingByIdProduct(int idProduct) {
        int sumRating = 0;
        int countIdProduct = 0;
        for (Feedback feedback : feedbacks) {
            if (feedback.product().id() == idProduct && feedback.rating() != 0) {
                countIdProduct++;
                sumRating += feedback.rating();
            }
        }
        System.out.println(sumRating + " : " + countIdProduct);
        double avg = Math.round(1.0 * sumRating / countIdProduct * 100.0) / 100.0;
        return "Average product rating " + avg + " out of 5 based on " + countIdProduct + " reviews";
    }
}
