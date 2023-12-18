package org.example.task1;

import org.example.task1.Pizza.PizzaBuilder;

public class Main {
    public static void main(String[] args) {
        Pizza pizza = new PizzaBuilder()
                .crust("thin")
                .sauce("tomato")
                .cheese(true)
                .pepperoni(true)
                .vegetables(true)
                .build();

        System.out.println("Crust: " + pizza.getCrust());
        System.out.println("Sauce: " + pizza.getSauce());
        System.out.println("Has cheese: " + pizza.hasCheese());
        System.out.println("Has pepperoni: " + pizza.hasPepperoni());
        System.out.println("Has vegetables: " + pizza.hasVegetables());
    }
}
