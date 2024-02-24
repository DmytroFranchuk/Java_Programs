
package org.example.dto;

import java.time.Duration;

public record IngredientResponseDto(String name, int nutrition, Duration cookingTime, int price){

}
