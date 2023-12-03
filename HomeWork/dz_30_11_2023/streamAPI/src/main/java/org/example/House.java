package org.example;

import java.util.List;
import java.util.Optional;

public class House {
    private List<Flat> flats;

    public House(List<Flat> flats) {
        this.flats = flats;
    }

    public List<Flat> getFlats() {
        return flats;
    }

    public Optional<Double> findFlatAreaGreaterThan(double area) {
        return flats.stream()
                .map(x -> x.getTotalArea())
                .filter(x -> x > area)
                .findFirst();
    }

    @Override
    public String toString() {
        return String.format("House: %s", flats);
    }
}
