package org.example.task1;

import java.util.Random;
// 1. Задача: вызов лифта
// В доме два лифта. Реализовать алгоритм отправки наиближайшего на вызывающий этаж.
// Алгоритм будет применяться в домах разной этажности.

public class Main {
    public static void main(String[] args) {
        runElevatorSimulation(19);
    }

    private static void runElevatorSimulation(int numberOfFloors) {
        int floorA = new Random().nextInt(1, numberOfFloors + 1);
        int floorB = new Random().nextInt(1, numberOfFloors + 1);
        int callingFloor = new Random().nextInt(1, numberOfFloors + 1);
        char chosenElevator = chooseElevator(floorA, floorB, callingFloor);
        System.out.println("Лифт A находится на " + floorA + " этаже.");
        System.out.println("Лифт B находится на " + floorB + " этаже.");
        System.out.println("Вызов был с " + callingFloor + " этажа.");
        System.out.println("Поехал на вызов лифт " + chosenElevator + ".");
    }

    private static char chooseElevator(int floorA, int floorB, int callingFloor) {
        return (Math.abs(floorA - callingFloor) < Math.abs(floorB - callingFloor)) ? 'A' : 'B';
    }
}