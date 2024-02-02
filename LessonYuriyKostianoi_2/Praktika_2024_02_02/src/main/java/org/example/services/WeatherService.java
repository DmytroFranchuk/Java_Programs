package org.example.services;

import org.example.dto.Weather;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class WeatherService {
    private Random random = new Random();

    public Weather getWeather(String town) {
        return new Weather(
                random.nextInt(-50, 45),
                random.nextInt(0, 100),
                random.nextInt(740, 780));
    }
}

