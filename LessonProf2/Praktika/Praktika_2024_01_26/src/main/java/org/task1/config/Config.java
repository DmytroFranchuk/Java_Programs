package org.task1.config;

import org.task1.pojo.Color;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;

@Configuration
@ComponentScan("org.task1.pojo")
public class Config {

    @Bean
    @Primary
    @Order(1)
    public Color red() {
        return new Color("red");
    }

    @Bean
    @Order(7)
    public Color orange() {
        return new Color("orange");
    }

    @Bean
    @Order(3)
    public Color blue() {
        return new Color("blue");
    }

    @Bean
    @Order(4)
    public Color darkBlue() {
        return new Color("darkBlue");
    }

    @Bean
    @Order(5)
    public Color green() {
        return new Color("green");
    }

    @Bean
    @Order(6)
    public Color violet() {
        return new Color("violet");
    }

    @Bean
    @Order(2)
    public Color yellow() {
        return new Color("yellow");
    }
}
