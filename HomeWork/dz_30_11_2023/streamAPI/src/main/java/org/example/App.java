package org.example;

import java.util.*;
import java.util.stream.Collectors;

import static org.example.Flat.newFlat;

public class App {
    public static void main(String[] args) {
        // Task 1
        Room room1 = new Room(22.5);
        Room room2 = new Room(15.3);
        Room room3 = new Room(33.7);
        Room room4 = new Room(26.1);
        Room room5 = new Room(54.8);
        Room room6 = new Room(12.9);
        Room room7 = new Room(72.4);

        Flat flat1 = new Flat(List.of(room1, room3, room5, room7));
        Flat flat2 = new Flat(List.of(room2, room4, room6, room7));
        Flat flat3 = new Flat(List.of(room1, room2, room3, room4));
        Flat flat4 = new Flat(List.of(room4, room5, room6, room7));
        Flat flat5 = new Flat(List.of(room2, room3, room5, room7));
        Flat flat6 = new Flat(List.of(room1, room4, room5, room6));

        House house1 = new House(List.of(flat1, flat2, flat3, flat4, flat5, flat6));
        System.out.println("===================================================================");

        double totalArea = house1.getFlats().stream()
                .map(flat -> flat.getRooms().stream()
                        .map(room -> room.getArea())
                        .reduce(0.0, (a, b) -> a + b))
                .reduce(0.0, (a, b) -> a + b);
        System.out.printf("Общая площадь дома: %.2f%n", totalArea);
        System.out.println("===================================================================");

        double totalArea1 = house1.getFlats().stream()
                .flatMap(flat -> flat.getRooms().stream())
                .mapToDouble(Room::getArea)
                .sum();
        System.out.printf("Общая площадь дома: %.2f%n", totalArea1);
        System.out.println("===================================================================");

        // Task 2
        Optional<Double> res = house1.findFlatAreaGreaterThan(100);
        if (res.isPresent()) System.out.printf("Площадь квартиры: %.2f%n", res.get());
        else System.out.println("Такой квартиры нет");
        System.out.println("===================================================================");

        // Task 3
        double percent = 1.3;
        List<Flat> newFlats = house1.getFlats().stream()
                .map(flat -> {
                    List<Room> newRooms = flat.getRooms().stream()
                            .map(room -> {
                                double newArea = room.getArea() * percent;
                                return new Room(newArea);
                            })
                            .collect(Collectors.toList());
                    return new Flat(newRooms);
                })
                .collect(Collectors.toList());
        House newHouse = new House(newFlats);
        System.out.println(newHouse);
        System.out.println("===================================================================");

        // Task 4
        Map<Room, Double> map1 = Map.of(
                room1, room1.getArea(),
                room3, room3.getArea(),
                room5, room5.getArea(),
                room7, room7.getArea()
        );
        Map<Room, Double> map2 = Map.of(
                room2, room2.getArea(),
                room4, room4.getArea(),
                room6, room6.getArea(),
                room7, room7.getArea()
        );
        Map<Room, Double> map3 = Map.of(
                room1, room1.getArea(),
                room2, room2.getArea(),
                room3, room3.getArea(),
                room4, room4.getArea()
        );
        Map<Room, Double> map4 = Map.of(
                room4, room4.getArea(),
                room5, room5.getArea(),
                room6, room6.getArea(),
                room7, room7.getArea()
        );
        Map<Room, Double> map5 = Map.of(
                room2, room2.getArea(),
                room3, room3.getArea(),
                room5, room5.getArea(),
                room7, room7.getArea()
        );
        Map<Room, Double> map6 = Map.of(
                room1, room1.getArea(),
                room4, room4.getArea(),
                room5, room5.getArea(),
                room6, room6.getArea()
        );
        List<Map<Room, Double>> listRooms = List.of(map1, map2, map3, map4, map5, map6);
        List<Flat> newFlat = newFlat(listRooms);
        System.out.println(newFlat);
        System.out.println(house1);
    }
}
