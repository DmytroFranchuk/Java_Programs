package org.lesson_Annotations.lesson_materials.AnnotationExample.example.climate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class SkyBasedWeatherMeasure extends WeatherMeasure {
    private SkyState skies;

    @Override
    public double getFeelingTemperature() {
        double temp = super.getFeelingTemperature();
        return skies == SkyState.SUNNY ? temp + Math.abs(temp * 0.1) : temp - temp * 0.2;
    }

    public enum SkyState {SUNNY, CLOUDY, RAIN, SNOW, SMOG}
}
