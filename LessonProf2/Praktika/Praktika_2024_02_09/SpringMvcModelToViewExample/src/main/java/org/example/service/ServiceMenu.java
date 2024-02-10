package org.example.service;

import org.example.dto.DishDto;
import org.example.entity.Dish;
import org.example.entity.Ingredient;
import org.example.mappper.DishMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@Service
public class ServiceMenu {
    private final Set<Dish> menu;
    private final DishMapper dishMapper;

    @Autowired
    public ServiceMenu(DishMapper dishMapper) {
        menu = new HashSet<>(Set.of(
                new Dish("French Potato", Map.of(new Ingredient("Potato", 200, Duration.ofMinutes(20), 2.0), 400)),
                new Dish("Scrambled eggs", Map.of(new Ingredient("Scrambled eggs", 150, Duration.ofMinutes(5), 1.0), 200))
        ));
        this.dishMapper = dishMapper;
    }

    public DishDto getByName(String name) {
        Dish dish = menu.stream().filter(d -> Objects.equals(d.name(), name)).findFirst().orElseThrow();
        return dishMapper.toDishDto(dish);
    }
}
