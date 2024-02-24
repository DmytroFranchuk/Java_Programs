package org.example.entity.dish;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.Duration;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Data
@ToString(exclude = {"dishes"})
@Entity
@NoArgsConstructor
@Table(name = "ingredients")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "nutrition")
    private int nutrition;
    @Column(name = "cooking_time")
    private Duration cookingTime;
    @Column(name = "price")
    private int price;
    @ManyToMany(mappedBy = "ingredients")
    private Set<Dish> dishes = new HashSet<>();

}
