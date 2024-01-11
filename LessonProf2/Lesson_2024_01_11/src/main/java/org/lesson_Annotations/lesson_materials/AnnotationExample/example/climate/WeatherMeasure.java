package org.lesson_Annotations.lesson_materials.AnnotationExample.example.climate;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class WeatherMeasure {
    private LocalDateTime dateTime;
    private double temperature;
    private int humidityPercent;
    private WindMeasure wind;

    public double getFeelingTemperature() {
        return temperature > 0 ? temperature * 0.1 * humidityPercent / 100 : temperature * 0.1 * wind.speed;
    }

    public record WindMeasure(double speed, GeoDirection direction) {
    }

    public enum GeoDirection {N, NE, E, SE, S, SW, W, NW}
}
