package org.example.mappper;

import org.example.dto.DishDto;
import org.example.entity.Dish;
import org.springframework.stereotype.Component;

@Component
public class DishMapper {
    public DishDto toDishDto(Dish dish) {
        return new DishDto(
                dish.name(),
                dish.ingredientsToWeight().keySet(),
                dish.calculateTime().toMinutes(),
                dish.calculatePrice(),
                dish.calculateNutrition()
        );
    }
}
