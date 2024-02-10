package org.example.entity;

import java.time.Duration;

public record Ingredient(
        String name,
        int nutritional,
        Duration cookingTime,
        double price) {

}
