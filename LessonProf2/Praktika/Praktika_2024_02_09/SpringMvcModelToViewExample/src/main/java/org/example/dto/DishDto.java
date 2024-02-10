package org.example.dto;

import org.example.entity.Ingredient;

import java.util.Set;

public record DishDto(
        String name,
        Set<Ingredient> ingredients,
        long cookingTime,
        double price,
        int nutrition) {
}
