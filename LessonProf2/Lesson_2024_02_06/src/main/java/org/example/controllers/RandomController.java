package org.example.controllers;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping("/random")
public class RandomController {

    private final Random rnd;
    private final Faker faker;

    @Autowired
    public RandomController(Random rnd, Faker faker) {
        this.rnd = rnd;
        this.faker = faker;
    }

    @GetMapping("/date")
    public LocalDate getDate(){
        return LocalDate.of(rnd.nextInt(2020,2025), rnd.nextInt(1,13), rnd.nextInt(1,28) );
    }

    @GetMapping("/time")
    public LocalTime getTime(){
        return LocalTime.of(rnd.nextInt(0,24), rnd.nextInt(0,60), rnd.nextInt(0,60) );
    }
    @GetMapping("/dateTime")
    public LocalDateTime getDateTime(){
        return LocalDateTime.of(getDate(), getTime());
    }

    @GetMapping("/uuid")
    public String getUUID(){
        return UUID.randomUUID().toString();
    }

    @GetMapping("/email")
    public String getEmail(){
        return faker.internet().emailAddress();
    }

    @GetMapping("/name")
    public String getName(){
        return faker.funnyName().name();
    }

    @GetMapping("/phone")
    public String getPhone(){
        return faker.phoneNumber().phoneNumber();
    }

    @GetMapping("/list")
    public List<Object> getAllInformation(){
        return List.of(getDate(), getTime(), getDateTime(), getUUID(), getEmail(), getName(), getPhone());
    }
}
