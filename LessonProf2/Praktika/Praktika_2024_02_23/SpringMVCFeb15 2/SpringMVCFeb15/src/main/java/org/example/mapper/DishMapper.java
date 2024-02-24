package org.example.mapper;

import org.example.dto.DishCreateRequestDto;
import org.example.dto.IngredientResponseDto;
import org.example.entity.dish.Dish;
import org.example.entity.dish.Ingredient;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DishMapper {
    public Dish toDish(DishCreateRequestDto dto, Set<IngredientResponseDto> ingredients) {
        return new Dish(null, dto.name(),);
    }
    public Ingredient toIngredient(IngredientResponseDto dto) {
        return Ingredient.builder()
                .id(dto.)
    }

}
