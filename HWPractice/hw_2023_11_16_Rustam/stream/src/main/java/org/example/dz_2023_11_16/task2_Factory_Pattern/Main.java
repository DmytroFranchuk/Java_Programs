package org.example.dz_2023_11_16.task2_Factory_Pattern;

public class Main {
    public static void main(String[] args) {

        VehicleFactory vehicleFactory = new VehicleFactory();

        Vehicle car = vehicleFactory.createVehicle("car");
        car.start();

        Vehicle bus = vehicleFactory.createVehicle("bus");
        bus.start();
    }
}
