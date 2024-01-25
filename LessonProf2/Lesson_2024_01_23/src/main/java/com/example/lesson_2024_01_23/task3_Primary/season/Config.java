package com.example.lesson_2024_01_23.task3_Primary.season;

import org.springframework.context.annotation.*;

import java.time.LocalDate;

@Configuration
@ComponentScan("com.example.lesson_2024_01_23.task3_Primary.season")
public class Config {
    @Bean
    @Scope("prototype")
    public Snow snow() {
        return new Snow();
    }

    @Bean
    public Season winter() {
        return new Winter(snow());
    }

    @Bean
    public Season autum() {
        return new Autum();
    }

    @Bean
    public Season summer() {
        return new Summer();
    }

    @Bean()
    @Primary
    public Season spring() {
        return new Spring();
    }

    @Bean(name = "currentSeason")
    public Season currentSeason() {
        return switch (LocalDate.now().getMonth()) {
            case JANUARY, FEBRUARY, DECEMBER  -> winter();
            case MARCH, APRIL, MAY  -> spring();
            case JULY, JUNE, AUGUST  -> summer();
            case SEPTEMBER, OCTOBER, NOVEMBER -> autum();
        };
    }
}
