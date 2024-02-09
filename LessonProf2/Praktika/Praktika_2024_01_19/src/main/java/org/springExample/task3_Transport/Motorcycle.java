package org.springExample.task3_Transport;

public class Motorcycle implements Transport{
    @Override
    public void drive() {
        System.out.println("Мотоцикл едет");
    }
}
