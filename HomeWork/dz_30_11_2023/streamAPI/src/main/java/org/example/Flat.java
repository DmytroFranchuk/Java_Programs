package org.example;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Flat {
    private List<Room> rooms;

    public Flat() {
    }

    public Flat(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public double getTotalArea() {
        return rooms.stream()
                .mapToDouble(x -> x.getArea())
                .sum();
    }

    public static List<Flat> newFlat(List<Map<Room, Double>> listRooms) {
        List<Flat> newFlats = listRooms.stream()
                .map(roomMap -> roomMap.entrySet().stream()
                        .map(entry -> {
                            Room room = entry.getKey();
                            Double area = entry.getValue();
                            return new Room(area);
                        })
                        .collect(Collectors.toList())
                )
                .map(roomsInFlat -> new Flat(roomsInFlat))
                .collect(Collectors.toList());
        return newFlats;
    }

    @Override
    public String toString() {
        return String.format("Flat: %s", rooms);
    }
}
