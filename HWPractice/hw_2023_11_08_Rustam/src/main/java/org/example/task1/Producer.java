package org.example.task1;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Producer extends Thread {

    private Car car;

    @Override
    public void run() {
        for (int i = 0; i <= 5; i++) {
            Cargo cargo = new Cargo("Груз " + i);
            car.carLoad(cargo);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
