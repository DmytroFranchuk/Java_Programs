package org.springExample.task3_Transport;

public class Bicycle implements Transport{
    @Override
    public void drive() {
        System.out.println("Велосипед едет");
    }
}
