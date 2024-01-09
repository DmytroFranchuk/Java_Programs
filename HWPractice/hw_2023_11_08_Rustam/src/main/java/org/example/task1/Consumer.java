package org.example.task1;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Consumer extends Thread {
    private Car car;

    @Override
    public void run() {
        while (true) {
            Cargo cargo = car.carUnload();

            if (cargo == null) {
                System.out.println("Все грузы получены. Работа завершена.");
                break;
            }

            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
