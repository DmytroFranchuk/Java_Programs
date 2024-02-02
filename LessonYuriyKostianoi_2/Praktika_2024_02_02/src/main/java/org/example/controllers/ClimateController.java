package org.example.controllers;
// Разработайте RESTful API, которое принимает название города и возвращает информацию о погоде
// в этом городе. Для простоты возвращайте заранее определенные данные.

import org.example.dto.Weather;
import org.example.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ClimateController {

    @Autowired
    private WeatherService service;

    @GetMapping("/town")
    public Weather getWether(@RequestParam(name = "name", required = true, defaultValue = "Berlin") String name) {
        return service.getWeather(name);
    }



}
