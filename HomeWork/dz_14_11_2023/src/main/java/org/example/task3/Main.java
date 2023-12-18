package org.example.task3;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        double speed = 10;
        List<Route> trip = List.of(
            new Route("Berlin", "Dresden", 220.0, 2.75),
            new Route("Dresden", "Praha", 170.0, 2.125),
            new Route("Praha", "Brno", 210.0, 2.625),
            new Route("Brno", "Budapest", 330.0, 4.125),
            new Route("Budapest", "Sofia", 740.0, 9.25),
            new Route("Sofia", "Plovdiv", 160.0, 2.0),
            new Route("Plovdiv", "Stambul", 363.0, 4.5375));

        int i = 0;
        LocalDateTime dataDeparture = LocalDateTime.now();
        for (Route route : trip) {
            if (i == 0 || i == 2) speed = 90;
            if (i == 1 || i == 6) speed = 80;
            if (i == 3 || i == 4) speed = 120;
            if (i == 5 ) speed = 70;
            route.setTravelTime(route.getDistance() / speed);
            LocalDateTime dataArrival = route.dataArrival(dataDeparture);
            System.out.println("Отправление из " + route.getCityFrom() + " " + dataDeparture.format(formatter)
                    + " прибытие в " + route.getCityTo() + " " + dataArrival.format(formatter));
            dataDeparture = dataArrival.plusMinutes(10);;
            i++;
        }
    }
}
