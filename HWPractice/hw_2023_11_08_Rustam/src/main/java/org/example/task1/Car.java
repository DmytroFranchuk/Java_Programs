package org.example.task1;

public class Car {
    private Cargo cargo;

    public synchronized void carLoad(Cargo cargo){
        while (this.cargo != null) {
            try {
                wait();
                System.out.println("Машина полностью загружена. Невозможно добавить новый груз. ");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
            this.cargo = cargo;
            System.out.println( cargo.getName() + ": загружен в машину");
        notify();
    }

    public synchronized Cargo carUnload() {
        while (cargo == null) {
            try {
                wait();
                System.out.println("Машина пуста. Ожидает загрузки груза");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Cargo unloadedCargo = cargo;
        System.out.println(cargo.getName() + ": выгружен из машины");
        cargo = null;
        notify();
        return unloadedCargo;
    }

}
