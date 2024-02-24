package org.example.dto;

import java.util.Set;

public record DishResponseDto(long id, String name, Set<IngredientCreateRequestDto> ingredientCreateRequestDto) {
}
