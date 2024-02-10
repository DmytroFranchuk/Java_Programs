package org.example.entity;

import java.time.Duration;
import java.util.Comparator;
import java.util.Map;

public record Dish(String name, Map<Ingredient, Integer> ingredientsToWeight) {

    public double calculatePrice() {
        return ingredientsToWeight.entrySet().stream()
                .mapToDouble(p -> p.getValue() * p.getKey().price())
                .sum();
    }

    public int calculateNutrition() {
        return ingredientsToWeight.entrySet().stream()
                .mapToInt(p -> p.getValue() * p.getKey().nutritional())
                .sum();
    }

    public Duration calculateTime() {
        return ingredientsToWeight.keySet().stream()
                .map(Ingredient::cookingTime)
                .max(Comparator.naturalOrder())
                .orElseThrow();
    }
}
