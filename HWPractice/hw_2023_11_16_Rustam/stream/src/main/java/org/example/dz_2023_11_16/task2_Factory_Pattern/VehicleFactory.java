package org.example.dz_2023_11_16.task2_Factory_Pattern;

public class VehicleFactory {
    public Vehicle createVehicle(String vehicleType) {
        if ("car".equalsIgnoreCase(vehicleType)) {
            return new Car();
        } else if ("bus".equalsIgnoreCase(vehicleType)) {
            return new Bus();
        }
        return null;
    }
}
