package org.springExample.task3_Transport;

public class Car implements Transport{
    @Override
    public void drive() {
        System.out.println("Машина едет");
    }
}
