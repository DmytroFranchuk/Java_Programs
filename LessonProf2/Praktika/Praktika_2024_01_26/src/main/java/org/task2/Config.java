package org.task2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("org.task2")
public class Config {
    @Bean
    @Scope("prototype")
    public FoodItem fish(){
        return new FoodItem("Fish");
    }
    @Bean
    @Scope("prototype")
    public FoodItem meat(){
        return new FoodItem("Meat");
    }
    @Bean
    @Scope("prototype")
    public FoodItem apple(){
        return new FoodItem("Apple");
    }
    @Bean
    @Scope("prototype")
    public FoodItem tomato(){
        return new FoodItem("Tomato");
    }
    @Bean
    @Scope("prototype")
    public FoodItem milk(){
        return new FoodItem("Milk");
    }
    @Bean
    @Scope("prototype")
    public FoodItem cheese(){
        return new FoodItem("Cheese");
    }
}
