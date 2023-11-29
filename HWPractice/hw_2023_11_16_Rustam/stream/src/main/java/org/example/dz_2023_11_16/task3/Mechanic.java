package org.example.dz_2023_11_16.task3;

import java.util.List;

public class Mechanic {

    public void serviceVehicle(Vehicle vehicle) {
        System.out.println("Servicing vehicle now");
        List<Wheel> wheels = vehicle.getWheels();

        for (Wheel wheel : wheels) {
            if (wheel.isBroken()) {
                wheel.repair();
            }
        }

        if (vehicle.isBroken()) {
            repairVehicle(vehicle);
        }
    }

    private void repairVehicle(Vehicle vehicle) {
        try {
            Thread.sleep(2000);
            System.out.println("Repair");
            vehicle.setBroken(false);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Repair interrupted");
        }
    }
}
