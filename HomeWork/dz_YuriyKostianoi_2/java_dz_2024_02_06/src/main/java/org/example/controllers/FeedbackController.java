package org.example.controllers;

import org.example.dto.FeedbackDto;
import org.example.dto.Product;
import org.example.services.FeedbackService;
import org.example.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FeedbackController {

    private final FeedbackService feedbackService;
    private final ProductService productService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService, ProductService productService) {
        this.feedbackService = feedbackService;
        this.productService = productService;
    }

    @GetMapping("/feedback-form") // вывод начальной формы обратной связи
    public String showFeedbackForm(Model model) {
        model.addAttribute("productList", productService.getProducts());
        model.addAttribute("feedbackDto", new FeedbackDto("", 0, ""));
        return "feedback-form";
    }

    @PostMapping("/feedback-submit") // принятие данных с формы обратной связи по нажатию кнопки
    public String processFeedbackForm(@ModelAttribute("feedbackDto") FeedbackDto feedbackDto) {
        feedbackService.saveFeedback(new FeedbackDto(feedbackDto.getNameProduct(), feedbackDto.getRating(),
                feedbackDto.getMessage()));
        return "redirect:/feedback-form";
    }

    @GetMapping("/avgProduct/{id}")
    public String averageRatingProduct(@PathVariable("id") int id, Model model) {
        String averageRating = feedbackService.averageRatingByIdProduct(id);
        Product product = productService.getProductById(id);
        model.addAttribute("averageRating", averageRating);
        model.addAttribute( "product", product);
        return "averageRatingProduct";
    }
}