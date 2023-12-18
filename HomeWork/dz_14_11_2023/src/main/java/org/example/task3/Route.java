package org.example.task3;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Route {
    private String cityFrom;
    private String cityTo;
    private double distance;
    private double travelTime;

    public Route(String cityFrom, String cityTo, double distance, double travelTime) {
        this.cityFrom = cityFrom;
        this.cityTo = cityTo;
        this.distance = distance;
        this.travelTime = travelTime;
    }

    public void setTravelTime(double travelTime) {
        this.travelTime = travelTime;
    }

    public LocalDateTime dataArrival(LocalDateTime departureDateTime) {
        int wholeHours = (int) getTravelTime();
        int minutes = (int) ((getTravelTime() - wholeHours) * 60);
        Duration travelDuration = Duration.ofHours(wholeHours).plusMinutes(minutes);
        LocalDateTime arrivalDateTime = departureDateTime.plus(travelDuration);
        return arrivalDateTime;
    }

    public double getTravelTime() {
        return travelTime;
    }

    public double getDistance() {
        return distance;
    }

    public String getCityFrom() {
        return cityFrom;
    }

    public String getCityTo() {
        return cityTo;
    }


}
